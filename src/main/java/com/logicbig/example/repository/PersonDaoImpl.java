package com.logicbig.example.repository;

import com.logicbig.example.model.Person;
import org.primefaces.model.FilterMeta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDaoImpl implements IPersonDao {
    private List<Person> people;

    @Override
    public List<Person> getPeople() {
        return new ArrayList<>(
                Arrays.asList(
                        Person.builder().id(1L).firstName("ali").lastName("raad").personalCode("23423424").nationalCode("5463636456").build()
                        , Person.builder().id(2L).firstName("sara").lastName("saiedi").personalCode("234234").nationalCode("45454").build()
                        , Person.builder().id(3L).firstName("shervin").lastName("bidari").personalCode("333333").nationalCode("0010064001").build()
                        , Person.builder().id(4L).firstName("rahim").lastName("shams").personalCode("555555").nationalCode("43").build()
                        , Person.builder().id(5L).firstName("arash").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(6L).firstName("vahid").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(7L).firstName("arya").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(8L).firstName("samad").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(9L).firstName("roya").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(10L).firstName("setare").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(11L).firstName("sina").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(12L).firstName("bahram").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(13L).firstName("hamid").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(14L).firstName("hasti").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(15L).firstName("arash").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(16L).firstName("arash").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                        , Person.builder().id(17L).firstName("arash").lastName("tavakoli").personalCode("1212100012").nationalCode("545").build()
                ));
    }

    @Override
    public List<Person> lazyLoad(int first,
                                 int pageSize,
                                 String sortField,
                                 String sortOrder,
                                 Map<String, FilterMeta> filterBy) {
        return getPeople().stream().skip(first).limit(pageSize).collect(Collectors.toList());
    }

}
