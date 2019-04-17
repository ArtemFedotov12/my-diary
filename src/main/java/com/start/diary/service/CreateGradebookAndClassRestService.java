package com.start.diary.service;

import com.start.diary.entities.ListOfClasses;
import com.start.diary.entities.ListOfSubjectForCertainClass;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ListOfClassesRepo;
import com.start.diary.repos.ListOfSubjectForCertainClassRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CreateGradebookAndClassRestService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ListOfSubjectForCertainClassRepo listOfSubjectForCertainClassRepo;
    @Autowired
    ListOfClassesRepo listOfClassesRepo;

    public void createGradebook(ListOfSubjectForCertainClass listOfSubjectForCertainClass, User user) {
        User userDb=userRepo.findById(user.getId());
        listOfSubjectForCertainClass.setUser(userDb);
        listOfSubjectForCertainClassRepo.save(listOfSubjectForCertainClass);
    }


    public ServiceResponse<Map<String, String>>  createClass(ListOfClasses listOfClasses, User user) {
        Map<String, String> map=new HashMap<>();
        ServiceResponse<Map<String, String>> response= new ServiceResponse<>("success", map);

        ListOfClasses listOfClassesDb=listOfClassesRepo.findByClassNumberAndClassLetter(
                listOfClasses.getClassNumber(),
                listOfClasses.getClassLetter()
        );
        if (listOfClassesDb!=null) {
            map.put("classNumberClassLetterError","Class with this number and letter already exists");
            response.setStatus("failure");
            System.out.println("classNumberClassLetterError");
            listOfClassesDb=null;
        }
        listOfClassesDb=listOfClassesRepo.findByAccessKeyForSchoolKid(listOfClasses.getAccessKeyForSchoolKid());
        if (listOfClassesDb!=null){
            map.put("accessKeyForSchoolKidError","Such access key already exists");
            response.setStatus("failure");
            System.out.println("accessKeyForSchoolKidError");
            listOfClassesDb=null;
        }


        if (map.isEmpty()) {
            User userDb=userRepo.findById(user.getId());
            listOfClasses.setUser(userDb);
            listOfClassesRepo.save(listOfClasses);
        }

        return response;
    }
}
