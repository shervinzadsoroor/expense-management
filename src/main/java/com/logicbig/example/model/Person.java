package com.logicbig.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
}
