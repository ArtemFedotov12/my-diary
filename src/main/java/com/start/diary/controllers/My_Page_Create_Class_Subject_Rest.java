package com.start.diary.controllers;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.My_Page_Create_Class_Subject_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class My_Page_Create_Class_Subject_Rest {
    @Autowired
    My_Page_Create_Class_Subject_Rest_Service create_Gradebook_Class_Subject_RestService;


/*    @PostMapping("/createGradebook")
    public ResponseEntity<Object> createGradebook(GradeBook subject,
                                                  @RequestParam int classNumber,
                                                  @RequestParam String classLetter,
                                                  User user) {

        ServiceResponse<Map<String, String>> response= create_Gradebook_Class_Subject_RestService.createGradebook(subject,user,classNumber,classLetter);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }*/


    @PostMapping("/createClass")
    public ResponseEntity<Object> createClass(ClassRoom classRoom,
                                              User user) {

        ServiceResponse<Map<String, String>> response= create_Gradebook_Class_Subject_RestService.createClass(classRoom,user);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/createSubject")
    public ResponseEntity<Object> createSubject(Subject subject,
                                                User user) {

        ServiceResponse<Map<String, String>> response= create_Gradebook_Class_Subject_RestService.createSubject(subject,user);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }




}
