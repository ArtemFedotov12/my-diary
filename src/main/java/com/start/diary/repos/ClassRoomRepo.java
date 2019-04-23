package com.start.diary.repos;

import com.start.diary.entities.ClassRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClassRoomRepo extends CrudRepository<ClassRoom, Integer> {

    public static final String FIND_PROJECTS =
            "SELECT DISTINCT class_number" +
            " FROM class_room" +
            " ORDER BY class_number ASC";
    @Query(value = FIND_PROJECTS, nativeQuery = true)
    Set<Integer> findClasses();

    ClassRoom findById(int id);
    ClassRoom findByAccessKeyForSchoolKid(String accessKeyForSchoolKid);
    ClassRoom findByClassNumberAndClassLetter(int classNumber, String classLetter);

}
