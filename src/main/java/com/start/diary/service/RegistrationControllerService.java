package com.start.diary.service;

import com.start.diary.entities.User;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationControllerService {
    @Autowired
    UserRepo userRepo;

    public boolean activateTeacher(String code) {
        User user = userRepo.findByActivationCodeEmail(code);

        if (user == null) {
            return false;
        }

        user.setActivationCodeEmail(null);
        user.setActiveEmail(true);
        userRepo.save(user);

        return true;
    }
}
