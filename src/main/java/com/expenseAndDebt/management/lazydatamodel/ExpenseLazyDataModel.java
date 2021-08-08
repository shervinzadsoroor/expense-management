package com.expenseAndDebt.management.lazydatamodel;

import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.service.IExpenseService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class ExpenseLazyDataModel extends LazyDataModel<ExpenseDTO> {

    private final IExpenseService iExpenseService;

    public ExpenseLazyDataModel(IExpenseService iExpenseService) {
        this.iExpenseService = iExpenseService;
    }

    @Override
    public List<ExpenseDTO> load(int first, int pageSize, String sortField,
                                 SortOrder sortOrder, Map<String, FilterMeta> filterBy) {
        return iExpenseService.getLazyDataList(first, pageSize, sortField, sortOrder, filterBy);
    }
}
