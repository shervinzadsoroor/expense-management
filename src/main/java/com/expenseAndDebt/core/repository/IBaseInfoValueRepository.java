package com.expenseAndDebt.core.repository;

import com.expenseAndDebt.core.model.BaseInfoValue;

import java.util.List;

public interface IBaseInfoValueRepository extends BaseRepository<BaseInfoValue> {
    List<BaseInfoValue> getAllByBaseInfoGroup_Id(Long groupId);
}
