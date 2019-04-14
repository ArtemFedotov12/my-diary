package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.MyPageRestService;
import org.springframework.beans.BeanUtils;
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
import java.util.Objects;

@RestController
public class MyPageRest {
    @Autowired
    MyPageRestService myPageRestService;

    //User user just match fields(name="some value" html) from mypage.ftl
    //with fields in User class
    @PostMapping("/mypage/edit")
    public ResponseEntity<Object> myPageEdit(MultipartFile file,
                                             MultipartFile file2,
                                             MultipartFile file3,
                                             User user
    ) throws IOException, InvocationTargetException, IllegalAccessException {

        System.out.println("Before");
        System.out.println("File1: " + file);
        System.out.println("File2: " + file2);
        if (file2!=null && !Objects.requireNonNull(file2.getOriginalFilename()).isEmpty()) {
            file = file2;
            System.out.println("Names");
            System.out.println("File1: " + file.getOriginalFilename());
            System.out.println("File2: " + file2.getOriginalFilename());
        }
        if(file3!=null && !Objects.requireNonNull(file3.getOriginalFilename()).isEmpty()){
            file = file3;
            System.out.println("Names");
            System.out.println("File1: " + file.getOriginalFilename());
            System.out.println("File3: " + file3.getOriginalFilename());
        }



        System.out.println("After");
        System.out.println("File1: " + file);
        System.out.println("File2: " + file2);
        System.out.println("Final Name");
        System.out.println(file.getOriginalFilename());

        ServiceResponse<Map<String, String>> response=myPageRestService.userEdit(file,user);
        System.out.println("Response Rest: " + response);


        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
