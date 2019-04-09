package com.start.diary.controllers;

import com.start.diary.entities.ActivationCode;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ActivationCodeForProductRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserControllerRest {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ActivationCodeForProductRepo activationCodeForProductRepo;

    @DeleteMapping("/delete/{user}")
    public ResponseEntity<Object> deleteUser(@PathVariable User user){
        System.out.println("tet");
        userRepo.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/generateCode/{user}")
    public ResponseEntity<Object> generate(@PathVariable User user){


       if(user.getActivationCodeForProductList()==null) {
           user.setActivationCodeForProductList(new ArrayList<>());
       }


        ActivationCode activationCode =new ActivationCode(UUID.randomUUID().toString());
        user.getActivationCodeForProductList().add(activationCode);
        userRepo.save(user);


        Map<Integer, String> map = user.getActivationCodeForProductList()
                .stream()
                .collect(Collectors.toMap(ActivationCode::getId, ActivationCode::getActivationCodeForProduct));
        ServiceResponse<Map<Integer, String>> response = new ServiceResponse<>("success", map);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/generateCode/{user}")
    public ResponseEntity<Object> tableCodeGeneration(@PathVariable User user){
        if(user.getActivationCodeForProductList()==null) {
            user.setActivationCodeForProductList(new ArrayList<>());
        }


        Map<Integer, String> map = user.getActivationCodeForProductList()
                .stream()
                .collect(Collectors.toMap(ActivationCode::getId, ActivationCode::getActivationCodeForProduct));
        ServiceResponse<Map<Integer, String>> response = new ServiceResponse<>("success", map);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
