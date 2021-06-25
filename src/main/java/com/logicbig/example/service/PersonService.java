package com.logicbig.example.service;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.PersonDao;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
