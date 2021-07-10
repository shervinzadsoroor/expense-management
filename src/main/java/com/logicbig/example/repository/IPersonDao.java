package com.logicbig.example.repository;

import com.logicbig.example.model.Person;
import org.primefaces.model.FilterMeta;

import java.util.List;
import java.util.Map;

public interface IPersonDao {

    List<Person> getPeople();

    List<Person> lazyLoad(int first, int pageSize, String sortField, String sortOrder, Map<String, FilterMeta> filterBy);
}
