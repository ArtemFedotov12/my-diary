package com.start.diary.repos;

import com.start.diary.entities.ListOfClasses;
import org.springframework.data.repository.CrudRepository;

public interface ListOfClassesRepo extends CrudRepository<ListOfClasses, Integer> {

    ListOfClasses findById(int id);
    ListOfClasses findByAccessKeyForSchoolKid(String accessKeyForSchoolKid);
    ListOfClasses findByClassNumberAndClassLetter(int classNumber,String classLetter);

}
