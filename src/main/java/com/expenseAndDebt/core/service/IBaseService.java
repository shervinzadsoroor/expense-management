package com.expenseAndDebt.core.service;

import com.expenseAndDebt.core.model.BaseDTO;
import com.expenseAndDebt.core.model.BaseEntity;

import java.util.List;

public interface IBaseService<E extends BaseEntity> {
    void saveOrUpdate(E entity);

    void batchSave(List<E> entities);

    void delete(E entity);

    void deleteAll(List<E> entities);

    E findById(Long id);

    List<E> findAll(List<Long> ids);
}
