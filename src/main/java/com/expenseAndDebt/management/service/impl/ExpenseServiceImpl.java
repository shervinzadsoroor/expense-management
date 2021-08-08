package com.expenseAndDebt.management.service.impl;

import com.expenseAndDebt.core.service.BaseService;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.repository.expense.ExpenseDao;
import com.expenseAndDebt.management.repository.expense.IExpenseCustomDao;
import com.expenseAndDebt.management.service.IExpenseService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpenseServiceImpl extends BaseService<Expense> implements IExpenseService {

    private final ExpenseDao expenseDao;
    private final IExpenseCustomDao iExpenseCustomDao;

    public ExpenseServiceImpl(ExpenseDao expenseDao, IExpenseCustomDao iExpenseCustomDao) {
        super(expenseDao);
        this.expenseDao = expenseDao;
        this.iExpenseCustomDao = iExpenseCustomDao;
    }

    @Override
    public void saveByDto(ExpenseDTO dto){
        Expense expense = new Expense();
        expense.getDomainObject(dto);
        saveOrUpdate(expense);
    }

    @Override
    public List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filterBy) {
        return iExpenseCustomDao.getLazyDataList(first, 5, sortField, sortOrder, filterBy);
    }
}
