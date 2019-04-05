package com.start.diary.service;

import com.start.diary.entities.Role;
import com.start.diary.entities.User;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class RegistrationService {
    private static String CAPTCHA_URL="https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    @Autowired
    TeacherService teacherService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSender mailSender;

    //its value from properties see
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${recaptcha.secret}")
    private String secret;


    public void handlingCaptchaAndFile(String captchaResponse, MultipartFile file, Map<String,String> map, User user) throws IOException {
        //System.out.println("Ppcccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
       /* String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (response != null && !response.isSuccess()) {
            map.put("captchaError", "Fill captcha");
        }*/
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


    public void addTeacherRegistration(User user, Map<String,String> map, String passwordConfirm, Errors errors){
        User userFromDatabaseByName =teacherRepo.findByLogin(user.getLogin());
        User userFromDatabaseByEmail =teacherRepo.findByEmail(user.getEmail());



        if (userFromDatabaseByName !=null){
            map.put("nameUniqueError", "User already exists!");
        }

        if (userFromDatabaseByEmail !=null){
            map.put("emailUniqueError", "Email has already been registered");

        }


        if (passwordConfirm.isEmpty()){
            map.put("passwordConfirmError", "Please confirm the password");

        }else {
            if (user.getPassword().compareTo(passwordConfirm)!= 0) {
                map.put("passwordConfirmEqualError", "Passwords are not equal");
            }
        }





//End!!!!!! if we don't have any errors(Error errors), we save our user
        if (map.isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            //3vid 17.30
            user.setRoles(Collections.singleton(Role.SCHOOLKID));

            //Email
            user.setActivationCodeEmail(UUID.randomUUID().toString());
            user.setActiveEmail(false);

            teacherRepo.save(user);
        }

    }


}
