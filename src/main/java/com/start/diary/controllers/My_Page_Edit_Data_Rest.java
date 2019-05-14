package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.service.My_Page_Edit_Data_Rest_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
public class My_Page_Edit_Data_Rest {
    @Autowired
    My_Page_Edit_Data_Rest_Service myPageEditDataRestService;

    //User user -- just match fields(name="some value" html) from mypage.ftl
    //with fields in User class
    @PostMapping("/mypage/edit")
    public ResponseEntity<Object> myPageEdit(MultipartFile file,
                                             MultipartFile file2,
                                             User user) throws IOException, InvocationTargetException, IllegalAccessException {

        ServiceResponse<Map<String, String>> response= myPageEditDataRestService.userEdit(file,file2,user);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
