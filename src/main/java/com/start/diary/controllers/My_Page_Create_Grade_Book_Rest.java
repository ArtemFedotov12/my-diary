package com.start.diary.controllers;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.GradeBook;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.My_Page_Create_Grade_Book_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class My_Page_Create_Grade_Book_Rest {
    @Autowired
    My_Page_Create_Grade_Book_Rest_Service myPageCreateGradeBookRestService;


    @PostMapping("/createGradebook")
    public ResponseEntity<Object> createGradebook(ClassRoom classRoom,
                                                  Subject subject,
                                                  User user) {

        ServiceResponse<Map<String, String>> response= myPageCreateGradeBookRestService.createGradebook(classRoom,subject,user);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }




    @GetMapping("/getListOfClassNumbers")
    public ResponseEntity<Object> createGradebook() {

        ServiceResponse<Set<Integer>> response= myPageCreateGradeBookRestService.getListOfClassNumbers();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getListOfClassLetters/{classNumber}")
    public ResponseEntity<Object> getListOfClassLetters(@PathVariable int classNumber) {

        ServiceResponse<Set<String>> response= myPageCreateGradeBookRestService.getListOfClassLetters(classNumber);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getListOfSubjects")
    public ResponseEntity<Object> getListOfSybjects() {

        ServiceResponse<Set<String>> response= myPageCreateGradeBookRestService.getListOfSubjects();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
