package com.start.diary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
public class TeacherNew {

    @XmlElement
    public String name;
    @XmlElement
    private String password;
    @XmlElement
    private String email;
    @XmlElement
    private String town;
    @XmlElement
    private String country;
    @XmlElement
    private String schoolnumber;

}
