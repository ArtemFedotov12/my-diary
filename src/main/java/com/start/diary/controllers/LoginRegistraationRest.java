package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginRegistraationRest {

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping("/lo")
    public ResponseEntity<Object> lo(@RequestParam String username){
        System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        Map<String,String> map = new HashMap<>();
        ServiceResponse<Map<String,String>> response = new ServiceResponse<>("success",map);
        if (!username.isEmpty()){


            Teacher teacher=teacherRepo.findByName(username);
            if (teacher!=null){
                if(teacher.isActive()==true){
                    map.put("email", "ok");
                }
                else {
                    map.put("email", "Bad");
                }
            }
        }

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
