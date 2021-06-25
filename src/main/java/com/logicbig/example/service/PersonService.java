package com.logicbig.example.service;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.PersonDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPeople() {
        List<Person> people = this.personDao.getPeople();
        people.forEach(person -> {
            if (person.getNationalCode().length() == 10)
                person.setIsNationalCodeValid(true);
            else
                person.setIsNationalCodeValid(false);
        });
        return people;
    }
}
