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
@Table(name = "listOfSubject")
public class ListOfSubjectForCertainClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int classNumber;
    private String classLetter;
    private String subject;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


}
