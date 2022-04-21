package com.expenseAndDebt.core.repository;

import java.util.List;
import java.util.Map;

public interface IBaseCustomDao {
    <T> List<T> getList(String query, Map<String, Object> params, Class<T> clazz);
}
