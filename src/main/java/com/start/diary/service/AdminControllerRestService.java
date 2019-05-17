package com.start.diary.service;

import com.start.diary.entities.ActivationCode;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminControllerRestService {
    @Autowired
    UserRepo userRepo;


    public ServiceResponse<Map<Integer, String>> generateCodePutMethod(User user) {

        if(user.getActivationCodeForProductList()==null) {
            user.setActivationCodeForProductList(new ArrayList<>());
        }

        ActivationCode activationCode = new ActivationCode(UUID.randomUUID().toString());
        user.getActivationCodeForProductList().add(activationCode);
        userRepo.save(user);

        //Get All activation Codes plus "new one"
        Map<Integer, String> map = user
                .getActivationCodeForProductList()
                .stream()
                .collect(Collectors.toMap(ActivationCode::getId, ActivationCode::getActivationCodeForProduct));

        return new ServiceResponse<>("success", map);
    }



    public ServiceResponse<Map<Integer, String>> generateCodeGetMethod(User user) {

        //class org.hibernate.collection.internal.PersistentBag
        if(user.getActivationCodeForProductList() == null) {
            user.setActivationCodeForProductList(new ArrayList<>());
        }


        Map<Integer, String> map = user.getActivationCodeForProductList()
                .stream()
                .collect(Collectors.toMap(ActivationCode::getId, ActivationCode::getActivationCodeForProduct));

        return new ServiceResponse<>("success", map);

    }
}
