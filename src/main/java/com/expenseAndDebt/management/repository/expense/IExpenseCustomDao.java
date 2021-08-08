package com.expenseAndDebt.management.repository.expense;

import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public interface IExpenseCustomDao {
    List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filterBy);
}
