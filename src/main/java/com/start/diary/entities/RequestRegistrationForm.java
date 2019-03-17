package com.start.diary.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class RequestRegistrationForm {
    private String name;
    private String password;
    private String passwordConfirm;
    private String email;
    private String town;
    private String country;
    private String schoolnumber;
    private MultipartFile filename;
}
