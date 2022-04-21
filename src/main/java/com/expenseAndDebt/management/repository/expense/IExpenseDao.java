package com.expenseAndDebt.management.repository.expense;

import com.expenseAndDebt.core.repository.BaseRepository;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IExpenseDao extends BaseRepository<Expense>, JpaSpecificationExecutor<Expense> {
}
