package com.logicbig.example.controller;

import com.logicbig.example.model.Person;
import com.logicbig.example.service.PersonService;
import lombok.Getter;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

    public void onEditInit(RowEditEvent event) {
        System.out.println("onEditInit: " + event.getObject());
    }

    public void onRowEdit(RowEditEvent<Person> event) {
        FacesMessage msg = new FacesMessage("person Edited", String.valueOf(event.getObject().getFirstName()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Person> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getFirstName()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
