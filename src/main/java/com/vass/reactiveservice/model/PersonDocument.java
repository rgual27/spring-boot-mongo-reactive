package com.vass.reactiveservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = PersonDocument.COLLECTION)
public class PersonDocument implements Serializable {

    public static final String COLLECTION = "persons";

    @Id
    private String id;

    private String name;

    private Date birthDay;
}
