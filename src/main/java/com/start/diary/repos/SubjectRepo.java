package com.start.diary.repos;

import com.start.diary.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<Subject, Integer> {

   Subject findByNameOfSubject(String nameOfSubject);
}
