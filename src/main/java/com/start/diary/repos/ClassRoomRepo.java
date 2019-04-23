package com.start.diary.repos;

import com.start.diary.entities.ClassRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClassRoomRepo extends CrudRepository<ClassRoom, Integer> {

    public static final String FIND_ClASS_NUMBERS =
            "SELECT DISTINCT class_number" +
            " FROM class_room" +
            " ORDER BY class_number ASC";
    @Query(value = FIND_ClASS_NUMBERS, nativeQuery = true)
    Set<Integer> findClassNumbers();

    public static final String FIND_ClASS_LETTERS=
            "SELECT DISTINCT class_letter" +
            "  FROM class_room" +
            " WHERE class_number = ?1";
    @Query(value = FIND_ClASS_LETTERS,nativeQuery = true)
    Set<String> findClassLetters(Integer classNumber);


    ClassRoom findById(int id);
    ClassRoom findByAccessKeyForSchoolKid(String accessKeyForSchoolKid);
    ClassRoom findByClassNumberAndClassLetter(int classNumber, String classLetter);

}
