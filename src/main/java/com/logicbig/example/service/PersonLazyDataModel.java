package com.logicbig.example.service;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.IPersonDao;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class PersonLazyDataModel extends LazyDataModel<Person> {

    private final IPersonDao iPersonDao;

    public PersonLazyDataModel(IPersonDao iPersonDao) {
        this.iPersonDao = iPersonDao;
    }

    @Override
    public List<Person> load(int first, int pageSize,
                             String sortField, SortOrder sortOrder,
                             Map<String, FilterMeta> filterBy) {
        return iPersonDao.lazyLoad(first, pageSize, null, null, null);
    }
}
