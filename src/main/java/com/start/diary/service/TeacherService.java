package com.start.diary.service;

import com.start.diary.controllers.ControllerUtils;
import com.start.diary.entities.Role;
import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import java.util.*;
import java.util.stream.Collectors;

//@Component and it just for information
//We created TeacherService implements UserDetailsService
//Via TeacherService we get user from DB method     !!!!public UserDetails loadUserByUsername!!!! in configure
@Service
public class TeacherService implements UserDetailsService {
    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailSender mailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepo.findByName(username);
        if(teacher==null || !teacher.isActive()){
            throw  new UsernameNotFoundException("User not find");
        }

        //TO DO check unique registration username(login)
        return teacher;
    }









    public void saveUser(Teacher teacher, String username, Map<String, String> form) {
        teacher.setName(username);
//https://annimon.com/article/2778---------Stream guide
        //Map<String, String> form key=User value=checked
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        teacher.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                teacher.getRoles().add(Role.valueOf(key));
            }
        }

        teacherRepo.save(teacher);
    }





    public boolean activateTeacher(String code) {
        Teacher teacher = teacherRepo.findByActivationCode(code);

        if (teacher == null) {
            return false;
        }

        teacher.setActivationCode(null);
        teacher.setActive(true);
        teacherRepo.save(teacher);

        return true;
    }


}
