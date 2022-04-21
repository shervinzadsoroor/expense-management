package com.expenseAndDebt.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BaseCustomDaoImpl implements IBaseCustomDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public <T> List<T> getList(String query, Map<String, Object> params, Class<T> clazz) {
        try {
            return jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(clazz));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
