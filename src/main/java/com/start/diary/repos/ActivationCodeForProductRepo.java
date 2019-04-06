package com.start.diary.repos;

import com.start.diary.entities.ActivationCode;
import org.springframework.data.repository.CrudRepository;

public interface ActivationCodeForProductRepo extends CrudRepository<ActivationCode, Integer> {

    ActivationCode findByActivationCodeForProduct(String activationCode);
}
