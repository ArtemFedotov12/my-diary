package com.start.diary.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
//Lombok
@Data
@NoArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Please fill the login")
    @Length(max = 60, message = "Message too long (more than 60symbols)")
    private String login;

    @NotBlank(message = "Please fill the password")
    private String password;

    @Email(message = "Email isn't correct")
    @NotBlank(message = "Please fill the email")
    private String email;

    @NotBlank(message = "Please fill the town")
    private String town;

    @NotBlank(message = "Please select the country")
    private String country;

    @NotBlank(message = "Please fill the number of school")
    private String schoolnumber;

    //@NotBlank(message = "Please fill the number of school")
    //i think it will be added automatic, Pupil won't write this, because teacher will give accessKey
    private String classNumber;

    private String filename;
    private String activationCodeEmail;
    private boolean activeEmail;
    //If DIRECTOR pay for product he will get this code
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ActivationCode> activationCodeForProduct;
    //it is located on DIRECTOR Home Page(Acces to all Gradebooks)
    private String accessKeyForTeacher;
    //it is located on User Home Page(on page classroom teacher)
    private String accessKeyForSchoolKid;

    //@OneToMany(cascade = { CascadeType.ALL })
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    //This field exist in separate table
    //3 vid 9.04
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

        //security.ftl it is used
    public boolean isAdmin(){
        return  roles.contains(Role.ADMIN);
    }


    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

}
