package com.start.diary.repos;

import com.start.diary.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//We can Save Object for example  -  teacherRepo.save(teacher);
public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
    //deal with this topic
    //https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE
    //    /reference/html/jpa.repositories.html#jpa.query-methods.query-creation
    Teacher findByName(String name);
    Teacher findByEmail(String name);
    Teacher findByActivationCode(String code);

}
