package com.start.diary.controllers;

import com.start.diary.service.RegistrationControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationControllerService registrationControllerService;

    @GetMapping("/registration")
    public String registrationGet() {
        return "registration";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActive = registrationControllerService.activateTeacher(code);


        if (isActive) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "main";
    }
}
