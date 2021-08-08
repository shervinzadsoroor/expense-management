package com.expenseAndDebt.core.service;

import com.expenseAndDebt.core.model.BaseInfoValue;
import com.expenseAndDebt.core.model.BaseInfoValueDTO;
import com.expenseAndDebt.core.repository.IBaseInfoValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseInfoValueServiceImpl implements IBaseInfoValueService {

    private final IBaseInfoValueRepository repository;

    public BaseInfoValueServiceImpl(IBaseInfoValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BaseInfoValueDTO> getAllByBaseInfoGroup(Long groupId) {
        return repository.getAllByBaseInfoGroup_Id(groupId)
                .stream().map(BaseInfoValue::getDtoObject).collect(Collectors.toList());
    }
}
