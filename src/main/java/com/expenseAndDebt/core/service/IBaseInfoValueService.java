package com.expenseAndDebt.core.service;

import com.expenseAndDebt.core.model.BaseInfoValueDTO;

import java.util.List;

public interface IBaseInfoValueService {
    List<BaseInfoValueDTO> getAllByBaseInfoGroup(Long groupId);
}
