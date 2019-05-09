package com.start.diary.service;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class My_Page_Create_Grade_Book_Rest_Service {
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Autowired
    SubjectRepo subjectRepo;
    public ServiceResponse<Set<Integer>> getListOfClassNumbers() {

       HashSet<Integer> classNumbers= (HashSet<Integer>) classRoomRepo.findClassNumbers();

        return new ServiceResponse<>("success", classNumbers);
    }

    public ServiceResponse<Set<String>> getListOfClassLetters(int classNumber) {

        HashSet<String> letters= (HashSet<String>) classRoomRepo.findClassLetters(classNumber);

        return new ServiceResponse<>("success", letters);

    }

    public ServiceResponse<Set<String>> getListOfSubjects() {

        HashSet<String> subjects= (HashSet<String>) subjectRepo.findSubjects();

        return new ServiceResponse<>("success", subjects);
    }
}
