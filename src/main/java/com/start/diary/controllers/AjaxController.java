package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;

@Controller
public class AjaxController {
    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping("/ajax")
    @RequestMapping("/ajax")
    @ResponseBody
    public String handlerRequest(@AuthenticationPrincipal Teacher teacher,
                                     @RequestParam(name="emailvalue") String emailvalue) {
        String response;
        JSONObject obj = new JSONObject();
        if (emailvalue.compareTo("optional")!=0){
            obj.put("status", "success");
            obj.put("email", emailvalue);

            teacher.setEmail(emailvalue);
            teacherRepo.save(teacher);
        }else {
            obj.put("status", "error");
        }
//
        return  obj.toString();
    }
}
