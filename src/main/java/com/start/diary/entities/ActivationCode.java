package com.start.diary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//Activation Code for Product
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
//Hibernate
@Entity
@Table(name = "activeProductCode")
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    @Column(name = "activeCodePr")
    String activationCodeForProduct;
}
