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

    @PostMapping("/mypage/edit")
    public ResponseEntity<Object> myPageEdit(@RequestParam("file") MultipartFile file,
                                             User user
    ) throws IOException {
        System.out.println("Rest Go");
        System.out.println(user);
        System.out.println(file.getOriginalFilename());



        return new ResponseEntity<>(HttpStatus.OK);
    }
}
