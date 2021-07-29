package com.expenseAndDebt.management.service;

import com.expenseAndDebt.core.service.IBaseService;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;

public interface IExpenseService extends IBaseService<Expense> {

    void saveByDto(ExpenseDTO dto);
}
