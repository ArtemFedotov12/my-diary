package com.start.diary.controllers;

import com.start.diary.entities.Role;
import com.start.diary.entities.User;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.AdminControllerService;
import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
//each method has path started with "/user"
@RequestMapping("/user")
public class AdminController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AdminControllerService adminControllerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("teacher", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userEdit(
            @RequestParam(name="id") User user,
            @RequestParam String login,
            //see UserEdit why it is called form
            @RequestParam Map<String, String> form
    )
    {
        adminControllerService.saveUser(user,login,form);
        return "redirect:/user";
    }

}
