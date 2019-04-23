package com.start.diary.controllers;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.MyPageCreateModelRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class MyPageCreateModelRest {
    @Autowired
    MyPageCreateModelRestService myPageCreateModelRestService;

    @GetMapping("/getListOfClasses")
    public ResponseEntity<Object> createGradebook() {

        ServiceResponse<Set<Integer>> response=myPageCreateModelRestService.getListOfClasses();

        System.out.println("GetClasses");
        System.out.println(response.getData());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
