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

    public ServiceResponse<Map<String, String>>  userEdit(MultipartFile file, User user) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        ServiceResponse<Map<String, String>> response;
        //Convert Object to Map
        ObjectMapper oMapper = new ObjectMapper();

        User userDb=userRepo.findById(user.getId());
        BeanUtilsBean copyWithoutNullFields=new NullAwareBeanUtilsBean();
        copyWithoutNullFields.copyProperties(userDb, user);


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


        userRepo.save(userDb);
        //Convert Object to Map
         map = oMapper.convertValue(userDb, Map.class);
         System.out.println("Map: " + map);
        response = new ServiceResponse<>("success", map);

        return response;
    }

}
