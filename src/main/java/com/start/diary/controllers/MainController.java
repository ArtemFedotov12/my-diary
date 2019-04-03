package com.start.diary.controllers;

import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    TeacherService teacherService;


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }


    @GetMapping("/mypage")
    public String bred(@AuthenticationPrincipal Teacher teacher, Model model) {
        Teacher teacher1=teacherRepo.findByLogin(teacher.getLogin());
        model.addAttribute("teacherPage",teacher1);
        return "mypage";
    }


    @GetMapping("/registration")
    public String registrationGet() {
        return "registration";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = teacherService.activateTeacher(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }




}
