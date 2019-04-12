package com.start.diary.controllers;

import com.start.diary.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MyPageRest {

    @PostMapping("/registration")
    public ResponseEntity<Object> test(@RequestParam("file") MultipartFile file, User user) throws IOException {



        return new ResponseEntity<>(HttpStatus.OK);
    }
}
