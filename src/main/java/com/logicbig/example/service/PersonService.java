package com.logicbig.example.service;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.PersonDao;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@Service
public class PersonService extends LazyDataModel<Person> {

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

    @Override
    public List<Person> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filterBy) {
        return super.load(first, pageSize, sortField, sortOrder, filterBy);
    }

    @Override
    public List<Person> getWrappedData() {
        return super.getWrappedData();
    }


}
