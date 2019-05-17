package com.start.diary.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "grade_book_grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    @CollectionTable(name = "grades_collection", joinColumns = @JoinColumn(name = "grade_book_grades_id"))
    private List<Integer> grades;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grade_book_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private GradeBook gradeBook;

    //Pupil
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}
