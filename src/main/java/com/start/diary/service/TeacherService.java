package com.start.diary.service;

import com.start.diary.entities.Role;
import com.start.diary.entities.Teacher;
import com.start.diary.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//@Component and it just for information
//We created TeacherService implements UserDetailsService
//Via TeacherService we get user from DB method     !!!!public UserDetails loadUserByUsername!!!! in configure
@Service
public class TeacherService implements UserDetailsService {
    @Autowired
    TeacherRepo teacherRepo;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Teacher teacher = teacherRepo.findByLogin(login);
        if(teacher==null || !teacher.isActiveEmail()){
            throw  new UsernameNotFoundException("User not find");
        }

        //TO DO check unique registration login(login)
        return teacher;
    }









    public void saveUser(Teacher teacher, String login, Map<String, String> form) {
        teacher.setLogin(login);
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
        Teacher teacher = teacherRepo.findByActivationCodeEmail(code);

        if (teacher == null) {
            return false;
        }

        teacher.setActivationCodeEmail(null);
        teacher.setActiveEmail(true);
        teacherRepo.save(teacher);

        return true;
    }


}
