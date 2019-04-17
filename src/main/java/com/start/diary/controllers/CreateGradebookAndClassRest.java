package com.start.diary.controllers;

import com.start.diary.entities.ListOfSubjectForCertainClass;
import com.start.diary.entities.User;
import com.start.diary.service.CreateGradebookAndClassRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

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

}
