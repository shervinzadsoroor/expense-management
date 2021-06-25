package com.logicbig.example.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
    private String nationalCode;
    private Boolean isNationalCodeValid;
}
