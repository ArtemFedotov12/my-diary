package com.start.diary.service;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class My_Page_Create_Grade_Book_Rest_Service {
    @Autowired
    ClassRoomRepo classRoomRepo;
    public ServiceResponse<Set<Integer>> getListOfClassNumbers() {

       HashSet<Integer> classNumbers= (HashSet<Integer>) classRoomRepo.findClassNumbers();

        return new ServiceResponse<>("success", classNumbers);
    }

    public ServiceResponse<Set<String>> getListOfClassLetters(int classNumber) {

        HashSet<String> classNumbers= (HashSet<String>) classRoomRepo.findClassLetters(classNumber);

        return new ServiceResponse<>("success", classNumbers);

    }
}
