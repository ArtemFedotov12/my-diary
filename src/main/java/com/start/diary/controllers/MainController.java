package com.start.diary.controllers;

import com.start.diary.entities.User;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TeacherService teacherService;


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }


    @GetMapping("/mypage")
    public String bred(@AuthenticationPrincipal User userAuth, Model model) {
        User userMyPage = userRepo.findById(userAuth.getId());
        model.addAttribute("userMyPage", userMyPage);
        return "mypage";
    }







}
