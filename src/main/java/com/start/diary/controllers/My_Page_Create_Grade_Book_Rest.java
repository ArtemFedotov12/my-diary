package com.start.diary.controllers;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.My_Page_Create_Grade_Book_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class My_Page_Create_Grade_Book_Rest {
    @Autowired
    My_Page_Create_Grade_Book_Rest_Service myPageCreateGradeBookRestService;

    @GetMapping("/getListOfClassNumbers")
    public ResponseEntity<Object> createGradebook() {

        ServiceResponse<Set<Integer>> response= myPageCreateGradeBookRestService.getListOfClassNumbers();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getListOfClassLetters/{classNumber}")
    public ResponseEntity<Object> getListOfClassLetters(@PathVariable int classNumber) {

        ServiceResponse<Set<String>> response= myPageCreateGradeBookRestService.getListOfClassLetters(classNumber);
        System.out.println(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getListOfSubjects")
    public ResponseEntity<Object> getListOfSybjects() {

        ServiceResponse<Set<String>> response= myPageCreateGradeBookRestService.getListOfSubjects();
        System.out.println(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
