package com.start.diary.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "gradeBook")
public class Gradebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String date;
    private int grade;
   /* @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subjectCertainClass_id", nullable = false)
    private ListOfSubjectForCertainClass listOfSubjectForCertainClass;*/


}
