package com.start.diary.entities.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ServiceResponse<T> {
    //success or failure
    private String status;
    private T data;
}
