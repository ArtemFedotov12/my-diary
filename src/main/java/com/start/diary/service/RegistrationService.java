package com.start.diary.service;

import com.start.diary.entities.Role;
import com.start.diary.entities.Teacher;
import com.start.diary.entities.dto.CaptchaResponseDto;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
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


    public void handlingCaptchaAndFile(String captchaResponse, MultipartFile file, Map<String,String> map, Teacher teacher) throws IOException {
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

            teacher.setFilename(resultFilename);
        }
    }


    public void addTeacherRegistration(Teacher teacher,Map<String,String> map, String passwordConfirm, Errors errors){
        Teacher teacherFromDatabaseByName=teacherRepo.findByLogin(teacher.getLogin());
        Teacher teacherFromDatabaseByEmail=teacherRepo.findByEmail(teacher.getEmail());



        if (teacherFromDatabaseByName!=null){
            map.put("nameUniqueError", "User already exists!");
        }

        if (teacherFromDatabaseByEmail!=null){
            map.put("emailUniqueError", "Email has already been registered");

        }


        if (passwordConfirm.isEmpty()){
            map.put("passwordConfirmError", "Please confirm the password");

        }else {
            if (teacher.getPassword().compareTo(passwordConfirm)!= 0) {
                map.put("passwordConfirmEqualError", "Passwords are not equal");
            }
        }





//End!!!!!! if we don't have any errors(Error errors), we save our user
        if (map.isEmpty()){
            teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
            //3vid 17.30
            teacher.setRoles(Collections.singleton(Role.SCHOOLKID));

            //Email
            teacher.setActivationCodeEmail(UUID.randomUUID().toString());
            teacher.setActiveEmail(false);
            //sendMessage(teacher);

            teacherRepo.save(teacher);
        }

    }

    //Email send Message
   /* private void sendMessage(Teacher teacher) {
        if (!StringUtils.isEmpty(teacher.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Electronic diary. Please, visit next link: http://localhost:8080/activate/%s",
                    teacher.getUsername(),
                    teacher.getActivationCodeEmail()
            );

            mailSender.send(teacher.getEmail(), "Activation code", message);
        }
    }*/

}
