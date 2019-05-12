package com.start.diary.repos;

import com.start.diary.entities.ClassRoom;
import com.start.diary.entities.GradeBook;
import com.start.diary.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface GradeBookRepo extends CrudRepository<GradeBook, Integer> {

    GradeBook findByClassRoomAndAndSubject(ClassRoom classRoom, Subject subject);
}
