package com.start.diary.repos;

import com.start.diary.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface GradesRepo extends CrudRepository<Subject, Integer> {
}
