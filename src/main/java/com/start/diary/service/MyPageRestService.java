package com.start.diary.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.diary.entities.User;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.UserRepo;
import com.start.diary.service.utils.NullAwareBeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class MyPageRestService {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    UserRepo userRepo;

    public ServiceResponse<Map<String, String>>  userEdit(MultipartFile file,
                                                          User user) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String> map;
        ServiceResponse<Map<String, String>> response;
        //Convert Object to Map
        ObjectMapper oMapper = new ObjectMapper();

        User userDb=userRepo.findById(user.getId());
        System.out.println("UserFromDbFirst: " + userDb);
        BeanUtilsBean copyWithoutNullFields=new NullAwareBeanUtilsBean();
        copyWithoutNullFields.copyProperties(userDb, user);

        System.out.println("UserJust: " + user);
        System.out.println("UserFromDb: " + userDb);


        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            userDb.setFilename(resultFilename);
        }

        //NullAwareBeanUtilsBean copy false, but
        //without activeEmail==true User even cann't log in the system
        //Therefore he don't have access to MyPage
        // so we can just write this setActiveEmail(true)
        userDb.setActiveEmail(true);
        userRepo.save(userDb);
        //Convert Object to Map
         map = oMapper.convertValue(userDb, Map.class);
        response = new ServiceResponse<>("success", map);

        return response;
    }

}
