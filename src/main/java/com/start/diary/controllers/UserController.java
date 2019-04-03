package com.start.diary.controllers;

import com.start.diary.entities.Role;
import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
//it is for you don't need to give login each method
@RequestMapping("/user")
public class UserController {
    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    TeacherService teacherService;



    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", teacherRepo.findAll());
        return "userList";
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{teacher}")
    public String userEditForm(@PathVariable Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userEdit(
            @RequestParam(name="id")Teacher teacher,
            @RequestParam String login,
            //see UserEdit why it is called form
            @RequestParam Map<String, String> form
    )


    {
        teacherService.saveUser(teacher,login,form);
        return "redirect:/user";
    }

}
