package com.start.diary.controllers;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.Gradebook_Page_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class GradeBook_Page_Rest {
    @Autowired
    Gradebook_Page_Rest_Service gradebook_page_rest_service;

    @GetMapping("/getListOfSubjectForCertainClassRoom/{classNumber}/{classLetter}")
    public ResponseEntity<Object> getListOfSubjectForCertainClassRoom(@PathVariable int classNumber,
                                                                      @PathVariable String classLetter) {
        ServiceResponse<Set<String>> response= gradebook_page_rest_service
                .getListOfSubjectsForCertainClassNumberAndClassLetter(classNumber,classLetter);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    //7   A     English
    //Get List of Kids who learn in this classRoom
    //CertainGradeBook because of table Grade_book (fields:  ClassRoom(7 A) ,  Subject(English)  )
    @GetMapping("/getListOfKidsForCertainGradeBook/{classNumber}/{classLetter}/{nameOfSubject}")
    public ResponseEntity<Object> getListOfKidsForCertainGradeBook(@Requesше tBody ClassRoom classRoom,
                                                                   Subject subject) {

        ServiceResponse<List<User>> response= gradebook_page_rest_service.getListOfKidsForCertainGradeBook(classRoom,subject);

        System.out.println("New Response");
        System.out.println(response);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
