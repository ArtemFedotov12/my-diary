package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllerRest {

    @Autowired
    TeacherRepo teacherRepo;


    @DeleteMapping("/delete/{user}")
    public ResponseEntity<Object> deleteUser(@PathVariable User user){
        System.out.println("tet");
        teacherRepo.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/generateCode")
    public ResponseEntity<Object> generate(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
