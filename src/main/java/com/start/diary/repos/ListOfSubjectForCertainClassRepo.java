package com.start.diary.repos;

import com.start.diary.entities.ListOfSubjectForCertainClass;
import org.springframework.data.repository.CrudRepository;

public interface ListOfSubjectForCertainClassRepo extends CrudRepository<ListOfSubjectForCertainClass, Integer> {

    ListOfSubjectForCertainClass findById(int id);
}
