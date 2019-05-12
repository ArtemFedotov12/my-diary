package com.start.diary.service;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.GradeBook;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.SubjectRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class My_Page_Create_Class_Subject_Rest_Service {
    @Autowired
    UserRepo userRepo;
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    ClassRoomRepo classRoomRepo;




    public ServiceResponse<Map<String, String>> createGradebook(GradeBook subject, User user, int classNumber, String classLetter) {

   /*     Map<String, String> map=new HashMap<>();
        ServiceResponse<Map<String, String>> response= new ServiceResponse<>("success", map);


        ClassRoom classRoomDb=classRoomRepo.findByClassNumberAndClassLetter(classNumber,classLetter);
        if (classRoomDb==null){
            map.put("classNumberClassLetterError","Class with this number and letter doesn't exist");
            response.setStatus("failure");
        }

      *//*  GradeBook subjectDb=subjectRepo.findByNameOfSubject(subject.getNameOfSubject());
        if(subjectDb!=null){
            map.put("nameOfSubjectError","Such subject already exists");
            response.setStatus("failure");
        }*//*



        if (map.isEmpty()) {
            System.out.println("Error1");
            User userDb=userRepo.findById(user.getId());
            subject.setUser(userDb);
            subjectRepo.save(subject);
        }*/

        return null;
    }







    public ServiceResponse<Map<String, String>>  createClass(ClassRoom classRoom, User user) {
        Map<String, String> map=new HashMap<>();
        ServiceResponse<Map<String, String>> response= new ServiceResponse<>("success", map);

        ClassRoom classRoomDb = classRoomRepo.findByClassNumberAndClassLetter(
                classRoom.getClassNumber(),
                classRoom.getClassLetter()
        );
        if (classRoomDb !=null) {
            map.put("classNumberClassLetterError","Class with this number and letter already exists");
            response.setStatus("failure");
            classRoomDb =null;
        }
        classRoomDb = classRoomRepo.findByAccessKeyForSchoolKid(classRoom.getAccessKeyForSchoolKid());
        if (classRoomDb !=null){
            map.put("accessKeyForSchoolKidError","Such access key already exists");
            response.setStatus("failure");
            System.out.println("accessKeyForSchoolKidError");
            classRoomDb =null;
        }


        if (map.isEmpty()) {
            User userDb=userRepo.findById(user.getId());
            classRoom.setUser(userDb);
            classRoomRepo.save(classRoom);
        }

        return response;
    }

    public ServiceResponse<Map<String, String>> createSubject(Subject subject, User user) {
        Map<String, String> map=new HashMap<>();
        ServiceResponse<Map<String, String>> response= new ServiceResponse<>("success", map);

        Subject subjectDb=subjectRepo.findByNameOfSubject(subject.getNameOfSubject());
        if(subjectDb!=null) {
            map.put("nameOfSubjectError","Such subject already exists");
            response.setStatus("failure");
        }

        if (map.isEmpty()) {
            User userDb=userRepo.findById(user.getId());
            subject.setUser(userDb);
            subjectRepo.save(subject);
        }

        return  response;

    }





}
