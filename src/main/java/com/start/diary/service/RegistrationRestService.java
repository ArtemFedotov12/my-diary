package com.start.diary.service;

import com.start.diary.controllers.utility.ControllerUtils;
import com.start.diary.entities.ActivationCode;
import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.Role;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.CaptchaResponseDto;
import com.start.diary.repos.ActivationCodeForProductRepo;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class RegistrationRestService {
    private static String CAPTCHA_URL="https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ActivationCodeForProductRepo activationCodeForProductRepo;

    @Autowired
    private MailSender mailSender;

    //its value from properties see
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${recaptcha.secret}")
    private String secret;


    public void handlingCaptchaAndFile(String captchaResponse, MultipartFile file, Map<String,String> map, User user) throws IOException {
        //System.out.println("Ppcccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (response != null && !response.isSuccess()) {
            map.put("captchaError", "Fill captcha");
        }
        //reCaptcha

        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            user.setFilename(resultFilename);
        }
    }


    public void addUserRegistration(User user, String activationCodeForProduct, Map<String,String> map, String passwordConfirm, Errors errors, String role){
        User userFromDatabaseByName = userRepo.findByLogin(user.getLogin());
        User userFromDatabaseByEmail = userRepo.findByEmail(user.getEmail());




        if (userFromDatabaseByName !=null) {
            map.put("loginUniqueError", "User already exists!");
        }

        if (userFromDatabaseByEmail !=null) {
            map.put("emailUniqueError", "Email has already been registered");

        }


        if (passwordConfirm.isEmpty()) {
            map.put("passwordConfirmError", "Please confirm the password");

        }else {
            if (user.getPassword().compareTo(passwordConfirm)!= 0) {
                map.put("passwordConfirmEqualError", "Passwords are not equal");
            }
        }

        //I indicated this field as hidden registrationDirector.ftl registrationTeacher.ftl
       if(role.compareTo("DIRECTOR")==0) {
           checkAdditionalFieldsForDirector(user, map, activationCodeForProduct);
           user.setRoles(Collections.singleton(Role.DIRECTOR));
       }
        if(role.compareTo("TEACHER")==0) {
            checkAdditionalFieldsForTeacher(user, map);
            //Only director have it
            user.setAccessKeyForTeacher(null);
            user.setRoles(Collections.singleton(Role.TEACHER));
        }

        if(role.compareTo("SCHOOLKID")==0) {
            checkAdditionalFieldsForSchoolKid(user, map);
            user.setAccessKeyForSchoolKid(null);
            user.setRoles(Collections.singleton(Role.SCHOOLKID));
        }


//End!!!!!! if we don't have any errors(Error errors), we save our user
        if (map.isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            //3vid 17.30
            //Email
            user.setActivationCodeEmail(UUID.randomUUID().toString());
            user.setActiveEmail(false);
            userRepo.save(user);
        }

    }



    private void checkAdditionalFieldsForDirector(User user, Map<String, String> map, String activationCodeForProduct) {

        if(activationCodeForProduct.isEmpty()){
            map.put("activationCodeForProductError", "Please fill the Activation Code");
        }else {
            ActivationCode activationCode=activationCodeForProductRepo.findByActivationCodeForProduct(activationCodeForProduct);
            if (activationCode==null){
                map.put("activationCodeForProductError", "Activation code is not valid");
            }
        }

        if(user.getTown().isEmpty()){
            map.put("townError", "Please fill the town");
        }
        if(user.getCountry().isEmpty()){
            map.put("countryError", "Please select the country");
        }
        if(user.getCountry().isEmpty()){
            map.put("countryError", "Please select the country");
        }

        if(user.getSchoolnumber().isEmpty()){
            map.put("schoolnumberError", "Please fill the number of school");
        }


    }

    private void checkAdditionalFieldsForTeacher(User user, Map<String, String> map) {
        if(user.getAccessKeyForTeacher().isEmpty()){
            map.put("accessKeyForTeacherError", "Please fill Access Key for teacher");
        }
        User userDb=userRepo.findByAccessKeyForTeacher(user.getAccessKeyForTeacher());
        System.out.println(userDb);
        if (userDb==null && !user.getAccessKeyForTeacher().isEmpty()){
            map.put("accessKeyForTeacherError", "Access Key isn't correct");
        }
    }

    private void checkAdditionalFieldsForSchoolKid(User user, Map<String, String> map) {
        if(user.getAccessKeyForSchoolKid().isEmpty()){
            map.put("accessKeyForSchoolKidError", "Please fill Access Key");
        }
        ClassRoom classRoomDb = classRoomRepo.findByAccessKeyForSchoolKid(user.getAccessKeyForSchoolKid());
        System.out.println(classRoomDb);
        if(classRoomDb ==null && !user.getAccessKeyForSchoolKid().isEmpty()){
            map.put("accessKeyForSchoolKidError", "Access Key isn't correct");
        }
    }


    public boolean checkErrors(Errors errors, Map<String, String> map) {

        if (errors.hasErrors() || !map.isEmpty()) {
            map.putAll(ControllerUtils.getErrors(errors));
            return true;
        }
        return false;
    }

    public void sendEmail(User user) {
        user=userRepo.findByLogin(user.getLogin());
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Electronic diary. Please, visit next link: http://localhost:8080/activate/%s",
                    //user.getUsername() implements UserDetails  equal to login
                    user.getUsername(),
                    user.getActivationCodeEmail()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }
}
