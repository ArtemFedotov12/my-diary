package com.start.diary.service;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gradebook_Page_Rest_Service {
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Autowired
    SubjectRepo subjectRepo;

    public ServiceResponse<Set<String>> getListOfSubjectsForCertainClassNumberAndClassLetter(int classNumber,String classLetter) {

        ClassRoom classRoom=classRoomRepo.findByClassNumberAndClassLetter(classNumber,classLetter);
        HashSet<String> listOfSubjects=
                (HashSet<String>) subjectRepo.findListOfSubjectsForCertainClassNumberAndClassLetter(classRoom.getId());

        return  new ServiceResponse<>("success", listOfSubjects);
    }

}
