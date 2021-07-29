package com.expenseAndDebt.management.repository;

import com.expenseAndDebt.core.repository.BaseRepository;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends BaseRepository<Expense> {
}
