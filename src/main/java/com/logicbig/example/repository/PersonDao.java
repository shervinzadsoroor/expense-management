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
                        new Person(1L, "ali", "raad", "345235")
                        , new Person(2L, "sara", "saiedi", "234234")
                        , new Person(3L, "shervin", "bidari", "333333")
                        , new Person(4L, "rahim", "shams", "555555")
                        , new Person(5L, "arash", "tavakoli", "1212100012")
                ));
    }
}
