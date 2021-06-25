package com.logicbig.example.controller;

import com.logicbig.example.model.Person;
import com.logicbig.example.service.PersonService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class PersonManagedBean {

    @Getter
    private List<Person> people;

    private final PersonService personService;

    public PersonManagedBean(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    public void init() {
        this.people = personService.getAllPeople();
    }
}
