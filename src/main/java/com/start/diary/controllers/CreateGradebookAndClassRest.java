package com.start.diary.controllers;

import com.start.diary.entities.ListOfClasses;
import com.start.diary.entities.ListOfSubjectForCertainClass;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.CreateGradebookAndClassRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.Map;

@RestController
public class CreateGradebookAndClassRest {
    @Autowired
    CreateGradebookAndClassRestService createGradebookAndClassRestService;
    @PostMapping("/createGradebook")
    public ResponseEntity<Object> createGradebook(ListOfSubjectForCertainClass listOfSubjectForCertainClass,
                                                  User user) {

        createGradebookAndClassRestService.createGradebook(listOfSubjectForCertainClass,user);


        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/createClass")
    public ResponseEntity<Object> createClass(ListOfClasses listOfClasses,
                                              User user) {

        System.out.println(listOfClasses);
        System.out.println(user);

        ServiceResponse<Map<String, String>> response= createGradebookAndClassRestService.createClass(listOfClasses,user);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
