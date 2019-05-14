package com.start.diary.controllers;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.Gradebook_Page_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Gradebook_Page_Rest {
    @Autowired
    Gradebook_Page_Rest_Service gradebook_page_rest_service;

    @GetMapping("/getListOfSubjectForCertainClassRoom/{classNumber}/{classLetter}")
    public ResponseEntity<Object> getListOfSubjectForCertainClassRoom(@PathVariable int classNumber,
                                                                      @PathVariable String classLetter) {


        ServiceResponse<Set<String>> response= gradebook_page_rest_service
                .getListOfSubjectsForCertainClassNumberAndClassLetter(classNumber,classLetter);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
