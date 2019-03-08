package com.start.diary.service;

import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginRegistrationService {
    @Autowired
    TeacherRepo teacherRepo;

    public void loginValidation(String username, Map<String,String> map){
        if (!username.isEmpty()){
            Teacher teacher = teacherRepo.findByName(username);
            if (teacher==null){
                map.put("isUserExist","false");
                return;
            }
            map.put("isUserExist","true");

            if(teacher.isActive()){
                map.put("email", "active");
            }
            else {
                map.put("email", "inactive");
            }
        }
    }
}
