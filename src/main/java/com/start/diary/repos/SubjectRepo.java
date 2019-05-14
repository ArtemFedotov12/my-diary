package com.start.diary.repos;

import com.start.diary.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SubjectRepo extends CrudRepository<Subject, Integer> {


   String FIND_SUBJECTS =
           "SELECT  name_of_subject" +
                   " FROM subject" +
                   " ORDER BY name_of_subject ASC";
   @Query(value = FIND_SUBJECTS, nativeQuery = true)
   Set<String> findSubjects();

   String FIND_LIST_OF_SUBJECTS=
                  "SELECT DISTINCT name_of_subject" +
                   "  from subject as s, grade_book as g" +
                   " where s.id=g.subject_id and g.class_room_id = ?1";
   @Query(value = FIND_LIST_OF_SUBJECTS,nativeQuery = true)
   Set<String> findListOfSubjectsForCertainClassNumberAndClassLetter(Integer classRoomId);


   Subject findByNameOfSubject(String nameOfSubject);



}
