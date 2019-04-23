package com.start.diary.service;

import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyPageCreateModelRestService {
    @Autowired
    ClassRoomRepo classRoomRepo;
    public ServiceResponse<Set<Integer>> getListOfClasses() {

       HashSet<Integer> classes= (HashSet<Integer>) classRoomRepo.findClasses();

        return new ServiceResponse<>("success", classes);
    }
}
