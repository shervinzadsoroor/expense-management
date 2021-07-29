package com.expenseAndDebt.management.service.impl;

import com.expenseAndDebt.core.service.BaseService;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.repository.ExpenseDao;
import com.expenseAndDebt.management.service.IExpenseService;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl extends BaseService<Expense> implements IExpenseService {

    private final ExpenseDao expenseDao;

    public ExpenseServiceImpl(ExpenseDao expenseDao) {
        super(expenseDao);
        this.expenseDao = expenseDao;
    }

    @Override
    public void saveByDto(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.getDomainObject(dto);
        saveOrUpdate(expense);
    }
}
