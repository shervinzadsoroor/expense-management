package com.expenseAndDebt.management.service;

import com.expenseAndDebt.core.service.IBaseService;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import org.primefaces.model.SortOrder;

import java.util.List;

public interface IExpenseService extends IBaseService<Expense> {

    void saveByDto(ExpenseDTO dto);

    List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, ExpenseDTO searchDto) throws Exception;

    List<ExpenseDTO> getAllMappedList() throws Exception;
}
