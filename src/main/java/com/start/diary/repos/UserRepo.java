package com.start.diary.repos;

import com.start.diary.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//We can Save Object for example  -  teacherRepo.save(teacher);
public interface UserRepo extends CrudRepository<User, Integer> {
    //deal with this topic
    //https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE
    //    /reference/html/jpa.repositories.html#jpa.query-methods.query-creation
    User findById(int id);
    User findByIdOrderByIdDesc(int id);
    User findByLogin(String login);
    User findByEmail(String email);
    User findByActivationCodeEmail(String code);
    User findByAccessKeyForTeacher(String accessKeyForTeacher);


    List<User> findByAccessKeyForSchoolKid(String accessKeyForSchoolKid);


}
