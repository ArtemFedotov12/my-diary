package com.start.diary.repos;

import com.start.diary.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SubjectRepo extends CrudRepository<Subject, Integer> {


   public static final String FIND_SUBJECTS =
                  "SELECT  name_of_subject" +
                   " FROM subject" +
                   " ORDER BY name_of_subject ASC";
   @Query(value = FIND_SUBJECTS, nativeQuery = true)
   Set<String> findSubjects();

   Subject findByNameOfSubject(String nameOfSubject);



}
