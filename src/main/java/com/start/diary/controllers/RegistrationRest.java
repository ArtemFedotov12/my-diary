package com.start.diary.controllers;

import com.start.diary.controllers.utility.ControllerUtils;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.MailSender;
import com.start.diary.service.RegistrationService;
import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistrationRest {

    @Autowired
    TeacherService teacherService;

    @Autowired
    private MailSender mailSender;

    //its value from properties see
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${recaptcha.secret}")
    private String secret;
    @Autowired
    UserRepo userRepo;

    @Autowired
    RegistrationService registrationService;


    @PostMapping("/registration")
    public ResponseEntity<Object> test(@RequestParam("file") MultipartFile file,
                                       @RequestParam String passwordConfirm,
                                       @RequestParam(name = "g-recaptcha-response", required = false) String captchaResponse,
                                       @RequestParam String activationCodeForProduct,
                                       @Valid User user,
                                       Errors errors
    ) throws IOException {

        Map<String, String> map = new HashMap<>(ControllerUtils.getErrors(errors));
        ServiceResponse<Map<String, String>> response = new ServiceResponse<>("success", map);


        registrationService.handlingCaptchaAndFile(captchaResponse, file, map, user);
        registrationService.addTeacherRegistration(user, activationCodeForProduct,map, passwordConfirm, errors);

        if (errors.hasErrors() || !map.isEmpty()) {
            response.setStatus("badRequest");
            map.putAll(ControllerUtils.getErrors(errors));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registration/email")
    public ResponseEntity<Object> email(User user) {
        user=userRepo.findByLogin(user.getLogin());
        System.out.println("String:22222222   "+ user.getActivationCodeEmail());
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
        return new ResponseEntity<>(HttpStatus.OK);
    }


}