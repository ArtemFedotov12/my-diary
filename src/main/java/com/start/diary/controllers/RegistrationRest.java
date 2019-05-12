package com.start.diary.controllers;

import com.start.diary.controllers.utility.ControllerUtils;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.MailSender;
import com.start.diary.service.RegistrationRestService;
import com.start.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    UserService userService;

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
    RegistrationRestService registrationRestService;


    @PostMapping("/registration")
    public ResponseEntity<Object> test(@RequestParam("file") MultipartFile file,
                                       @RequestParam String passwordConfirm,
                                       @RequestParam(name = "g-recaptcha-response", required = false) String captchaResponse,
                                       String activationCodeForProduct,
                                       @RequestParam String role,
                                       @Valid User user,
                                       Errors errors
    ) throws IOException {
        System.out.println("RegistrationRest");

        Map<String, String> map = new HashMap<>(ControllerUtils.getErrors(errors));
        ServiceResponse<Map<String, String>> response = new ServiceResponse<>("success", map);


        registrationRestService.handlingCaptchaAndFile(captchaResponse, file, map, user);
        registrationRestService.addUserRegistration(user, activationCodeForProduct,map, passwordConfirm, errors,role);

       boolean checkErrors=registrationRestService.checkErrors(errors,map);
        if (checkErrors) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registration/email")
    public ResponseEntity<Object> email(User user) {

        registrationRestService.sendEmail(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
