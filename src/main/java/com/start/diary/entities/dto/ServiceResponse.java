package com.start.diary.entities.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ServiceResponse<T> {

    private String status;
    private T data;
}
