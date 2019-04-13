package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.MyPageRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
public class MyPageRest {
    @Autowired
    MyPageRestService myPageRestService;

    //User user just match fields(name="some value" html) from mypage.ftl
    //with fields in User class
    @PostMapping("/mypage/edit")
    public ResponseEntity<Object> myPageEdit(MultipartFile file,
                                             User user
    ) throws IOException, InvocationTargetException, IllegalAccessException {

        ServiceResponse<Map<String, String>> response=myPageRestService.userEdit(file,user);
        System.out.println("Response Rest: " + response);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
