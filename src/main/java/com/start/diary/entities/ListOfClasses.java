package com.start.diary.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "listOfClasses")
public class ListOfClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int classNumber;
    private String classLetter;
    private String accessKeyForSchoolKid;
   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;*/
}
