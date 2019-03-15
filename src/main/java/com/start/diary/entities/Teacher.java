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
import java.util.Collection;
import java.util.Set;
//Lombok
@Data
@NoArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "teacher")
public class Teacher implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Please fill the name")
    @Length(max = 60, message = "Message too long (more than 60symbols)")
    private String name;

    @NotBlank(message = "Please fill the password")
    private String password;

    @NotBlank(message = "Please confirm the password")
    @Transient
    private String passwordConfirm;

    @Email(message = "Email isn't correct")
    @NotBlank(message = "Please fill the email")
    private String email;

    @NotBlank(message = "Please fill the town")
    private String town;

    private String country;

    @NotBlank(message = "Please fill the number of school")
    private String schoolnumber;

    private String filename;
    private String activationCode;
    private boolean active;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    //This field exist in separate table
    //3 video 9.04
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @Override
    public String getUsername() {
        return name;
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
