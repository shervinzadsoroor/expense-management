package com.logicbig.example.repository;

import com.logicbig.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonDao {
    private List<Person> people;

    public List<Person> getPeople() {
        return new ArrayList<>(
                Arrays.asList(
                        Person.builder().id(1L).firstName("ali").lastName("raad").personalCode("23423424").nationalCode("5463636456").build()
                        , Person.builder().id(2L).firstName("sara").lastName("saiedi").personalCode("234234").nationalCode("45454").build()
                        , Person.builder().id(3L).firstName("shervin").lastName("bidari").personalCode("333333").nationalCode("0010064001").build()
                        , Person.builder().id(4L).firstName("rahim").lastName("shams").personalCode("555555").nationalCode("43").build()
                        , Person.builder().id(5L).firstName("arash").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                ));
    }
}
