package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    TeacherRepo teacherRepo;


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }
    @GetMapping("/bad")
    public String bad() {
        return "bad";
    }

    @GetMapping("/mypage")
    public String bred(@AuthenticationPrincipal Teacher teacher, Model model) {
        Teacher teacher1=teacherRepo.findByName(teacher.getName());
        model.addAttribute("teacherPage",teacher1);
        return "mypage";
    }

    @GetMapping("/lo")
    public @ResponseBody String lo(@RequestParam String username){
        System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        JSONObject obj = new JSONObject();
        if (!username.isEmpty()){
            obj.put("status", "success");
            obj.put("username", username);
            Teacher teacher=teacherRepo.findByName(username);
            if (teacher!=null){
                if(teacher.isActive()==true){
                    obj.put("email", "ok");
                }
                else {
                    obj.put("email", "Bad");
                }
            }
        }
        else {
            obj.put("status", "error");
        }
        return obj.toString();
    }



}
