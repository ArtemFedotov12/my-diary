package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllerRest {

    @Autowired
    TeacherRepo teacherRepo;


    @DeleteMapping("/delete/{teacher}")
    public ResponseEntity<Object> deleteUser(@PathVariable Teacher teacher){
        System.out.println("tet");
        //teacherRepo.delete(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
