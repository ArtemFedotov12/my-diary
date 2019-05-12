package com.start.diary.service;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.GradeBook;
import com.start.diary.entities.Subject;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.ClassRoomRepo;
import com.start.diary.repos.GradeBookRepo;
import com.start.diary.repos.SubjectRepo;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class My_Page_Create_Grade_Book_Rest_Service {
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    GradeBookRepo gradeBookRepo;
    @Autowired
    UserRepo userRepo;


    public ServiceResponse<Map<String, String>> createGradebook(ClassRoom classRoom,
                                                         Subject subject,
                                                         User user) {

        Map<String, String> map=new HashMap<>();
        ServiceResponse<Map<String, String>> response= new ServiceResponse<>("success", map);

        //Maybe all this check for errors is redundant, because when you create gradeBook
        //You choose values from select(html tag)
        //Options for select(html tag) loads with Ajax from DB

        ClassRoom classRoomDb=classRoomRepo.findByClassNumberAndClassLetter(classRoom.getClassNumber(),classRoom.getClassLetter());
        if (classRoomDb ==null) {
            map.put("classNumberClassLetterError","Class with this number and letter don't exist");
            response.setStatus("failure");
        }
        Subject subjectDb=subjectRepo.findByNameOfSubject(subject.getNameOfSubject());
        if (subjectDb ==null) {
            map.put("nameOfSubjectError","Such subject doesn't exist");
            response.setStatus("failure");
        }
        User userDb=userRepo.findById(user.getId());
        if (userDb ==null) {
            map.put("userError","Such user doesn't exist");
            response.setStatus("failure");
        }



        if(map.isEmpty()){
            GradeBook gradeBookDb=gradeBookRepo.findByClassRoomAndAndSubject(classRoomDb,subjectDb);
            if (gradeBookDb !=null) {
                map.put("gradeBookError","Such gradebook already exists");
                response.setStatus("failure");
            }
            else {
                GradeBook gradeBook =new GradeBook();
                gradeBook.setClassRoom(classRoomDb);
                gradeBook.setSubject(subjectDb);
                gradeBook.setUser(userDb);
                gradeBookRepo.save(gradeBook);
            }
        }

        return response;
    }



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
