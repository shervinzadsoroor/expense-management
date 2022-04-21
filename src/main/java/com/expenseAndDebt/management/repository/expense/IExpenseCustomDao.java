package com.expenseAndDebt.management.repository.expense;

import com.expenseAndDebt.core.repository.IBaseCustomDao;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import org.primefaces.model.SortOrder;

import java.util.List;

public interface IExpenseCustomDao extends IBaseCustomDao {
    List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, ExpenseDTO searchDto) throws Exception;

    List<ExpenseDTO> getAllMappedList() throws Exception;
}
