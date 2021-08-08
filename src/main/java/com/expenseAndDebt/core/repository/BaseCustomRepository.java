package com.expenseAndDebt.core.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseCustomRepository {
    @PersistenceContext
    protected EntityManager entityManager;
}
