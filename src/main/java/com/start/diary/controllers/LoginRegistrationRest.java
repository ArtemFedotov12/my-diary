package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.TeacherRepo;
import com.start.diary.service.LoginRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginRegistrationRest {

    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    LoginRegistrationService loginRegistrationService;

    @GetMapping("/lo")
    public ResponseEntity<Object> lo(@RequestParam String username){
        System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        Map<String,String> map = new HashMap<>();
        ServiceResponse<Map<String,String>> response = new ServiceResponse<>("success",map);

            loginRegistrationService.loginValidation(username,map);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
