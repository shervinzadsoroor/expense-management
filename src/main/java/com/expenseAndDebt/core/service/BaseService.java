package com.expenseAndDebt.core.service;

import com.expenseAndDebt.core.model.BaseEntity;
import com.expenseAndDebt.core.repository.BaseRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class BaseService<E extends BaseEntity> implements IBaseService<E>{

    protected final BaseRepository<E> baseRepository;

    public BaseService(BaseRepository<E> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void saveOrUpdate(E entity) {
        baseRepository.save(entity);
    }

    @Override
    public void batchSave(List<E> entities) {
        entities.forEach(this::saveOrUpdate);

    }

    @Override
    public void delete(E entity) {
        baseRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<E> entities) {
        baseRepository.deleteAll(entities);
    }

    @Override
    public E findById(Long id) {
        return baseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<E> findAll(List<Long> ids) {
        return baseRepository.findAllById(ids);
    }
}
