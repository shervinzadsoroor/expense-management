package com.logicbig.example.service;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.PersonDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDaoImpl personDaoImpl;

    public PersonService(PersonDaoImpl personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    public List<Person> getAllPeople() {
        List<Person> people = this.personDaoImpl.getPeople();
        people.forEach(person -> {
            person.setIsNationalCodeValid(person.getNationalCode().length() == 10);
        });
        return people;
    }
}
