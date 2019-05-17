package com.start.diary.service;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.Grades;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.SubjectRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Gradebook_Page_Rest_Service {
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    UserRepo userRepo;

    public ServiceResponse<Set<String>> getListOfSubjectsForCertainClassNumberAndClassLetter(int classNumber,String classLetter) {

        ClassRoom classRoom=classRoomRepo.findByClassNumberAndClassLetter(classNumber,classLetter);
        HashSet<String> listOfSubjects=
                (HashSet<String>) subjectRepo.findListOfSubjectsForCertainClassNumberAndClassLetter(classRoom.getId());

        return  new ServiceResponse<>("success", listOfSubjects);
    }


    public ServiceResponse<List<User>> getListOfKidsForCertainGradeBook(ClassRoom classRoom, Subject subject) {

        ClassRoom classRoomDb = classRoomRepo
                .findByClassNumberAndClassLetter(classRoom.getClassNumber(),classRoom.getClassLetter());
        ArrayList<User> users= (ArrayList<User>) userRepo
                .findByAccessKeyForSchoolKid(classRoomDb.getAccessKeyForSchoolKid());

        ArrayList<User> usersResponse= (ArrayList<User>) users.stream()
             .peek(s->s.setPassword("default"))
             .collect(Collectors.toList());


        return new ServiceResponse<>("success", usersResponse);
    }



}
