package com.start.diary.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
public class User implements UserDetails{
    //private static final long serialVersionUID =-1239304182;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Please fill the login")
    @Length(max = 60, message = "Message too long (more than 60symbols)")
    private String login;

    @NotBlank(message = "Please fill the password")
    private String password;

    @NotBlank(message = "Please fill the First Name")
    private String firstName;

    @NotBlank(message = "Please fill the Last Name")
    private String lastName;

    @NotBlank(message = "Please fill the Patronymic")
    private String patronymic ;

    @Email(message = "Email isn't correct")
    @NotBlank(message = "Please fill the email")
    private String email;


    private String town;


    private String country;


    private String schoolnumber;


    private String accessKeyForTeacher;

    private String activationCodeEmail;
    //@NotBlank(message = "Please fill the number of school")
    //i think it will be added automatic, Pupil won't write this, because teacher will give accessKey
    private String classNumber;

    //in html(ftl) we don't use filename to pass file
    //in html we write  type="file" name="file" and get MultipartFile file
    private String filename;

    private boolean activeEmail;
    //If DIRECTOR pay for product he will get this code
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<ActivationCode> activationCodeForProductList;


    //it is located on User Home Page(on page classroom teacher)
    private String accessKeyForSchoolKid;

    //@OneToMany(cascade = { CascadeType.ALL })
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    //This field exist in separate table
    //3 vid 9.04
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

  /*  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<GradeBook> listOfSubjectForCertainClasses;*/

    //security.ftl it is used
    public boolean isAdmin() {
        return  roles.contains(Role.ADMIN);
    }
    //security.ftl it is used
    public boolean isDirector() {
        return  roles.contains(Role.DIRECTOR);
    }
    public boolean isTeacher() {
        return  roles.contains(Role.TEACHER);
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
