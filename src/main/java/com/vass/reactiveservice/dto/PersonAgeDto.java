package com.vass.reactiveservice.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PersonAgeDto {

    private static final long serialVersionUID = 987616857654321989L;

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;
}
