package com.start.diary.service;

import com.start.diary.entities.ListOfSubjectForCertainClass;
import com.start.diary.entities.User;
import com.start.diary.repos.ListOfSubjectForCertainClassRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateGradebookAndClassRestService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ListOfSubjectForCertainClassRepo listOfSubjectForCertainClassRepo;

    public void createGradebook(ListOfSubjectForCertainClass listOfSubjectForCertainClass, User user) {
        User userDb=userRepo.findById(user.getId());
        listOfSubjectForCertainClass.setUser(userDb);
        listOfSubjectForCertainClassRepo.save(listOfSubjectForCertainClass);
    }
}
