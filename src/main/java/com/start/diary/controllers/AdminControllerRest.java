package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ActivationCodeForProductRepo;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.AdminControllerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AdminControllerRest {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ActivationCodeForProductRepo activationCodeForProductRepo;
    @Autowired
    AdminControllerRestService adminControllerRestService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{user}")
    public ResponseEntity<Object> deleteUser(@PathVariable User user){
        userRepo.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/generateCode/{user}")
    public ResponseEntity<Object> generate(@PathVariable User user){

        ServiceResponse<Map<Integer, String>> response = adminControllerRestService.generateCodePutMethod(user);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/generateCode/{user}")
    public ResponseEntity<Object> tableCodeGeneration(@PathVariable User user){

        ServiceResponse<Map<Integer, String>> response = adminControllerRestService.generateCodeGetMethod(user);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
