package com.expenseAndDebt.management.service.impl;

import com.expenseAndDebt.core.service.BaseService;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.repository.expense.IExpenseCustomDao;
import com.expenseAndDebt.management.repository.expense.IExpenseDao;
import com.expenseAndDebt.management.service.IExpenseService;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl extends BaseService<Expense> implements IExpenseService {

    private final IExpenseDao expenseDao;
    private final IExpenseCustomDao iExpenseCustomDao;

    public ExpenseServiceImpl(IExpenseDao expenseDao, IExpenseCustomDao iExpenseCustomDao) {
        super(expenseDao);
        this.expenseDao = expenseDao;
        this.iExpenseCustomDao = iExpenseCustomDao;
    }

    @Override
    public void saveByDto(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.getDomainObject(dto);
        saveOrUpdate(expense);
    }

    @Override
    public List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, ExpenseDTO searchDto) throws Exception {
        return iExpenseCustomDao.getLazyDataList(first, 5, sortField, sortOrder, searchDto);
    }

    @Override
    public List<ExpenseDTO> getAllMappedList() throws Exception {
//        ExpenseSpecifications specifications = new ExpenseSpecifications(new SearchCriteria("amount", ">", 5));
//        expenseDao.findAll(specifications);

        return iExpenseCustomDao.getAllMappedList();
    }
}
