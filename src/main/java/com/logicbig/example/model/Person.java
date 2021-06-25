package com.logicbig.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
}
