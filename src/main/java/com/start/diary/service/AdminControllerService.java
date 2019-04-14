package com.start.diary.service;

import com.start.diary.entities.Role;
import com.start.diary.entities.User;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminControllerService {
    @Autowired
    UserRepo userRepo;

    public void saveUser(User user, String login, Map<String, String> form) {
        user.setLogin(login);
//https://annimon.com/article/2778---------Stream guide
        //Map<String, String> form key=User value=checked
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        System.out.println(user.getRoles().toString());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        System.out.println(user.getRoles().toString());

        userRepo.save(user);
    }
}
