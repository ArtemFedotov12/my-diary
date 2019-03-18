package com.start.diary.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RequestRegistrationForm {
    @NotBlank(message = "Please fill the name")
    @Length(max = 60, message = "Message too long (more than 60symbols)")
    private String name;

    @NotBlank(message = "Please fill the password")
    private String password;

/*    @NotBlank(message = "Please confirm the password")
    private String passwordConfirm;

    @Email(message = "Email isn't correct")
    @NotBlank(message = "Please fill the email")
    private String email;

    @NotBlank(message = "Please fill the town")
    private String town;

    @NotBlank(message = "Please select the country")
    private String country;

    @NotBlank(message = "Please fill the number of school")
    private String schoolnumber;*/

    //private MultipartFile filename;
}
