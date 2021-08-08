package com.expenseAndDebt.management.repository.expense.impl;

import com.expenseAndDebt.core.repository.BaseCustomRepository;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.repository.expense.IExpenseCustomDao;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ExpenseCustomDao extends BaseCustomRepository implements IExpenseCustomDao {
    @Override
    public List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filterBy) {
        String query = "select * from EXPENSE e limit " + first + ", " + pageSize;
        List<Expense> result =
                this.entityManager.createNativeQuery(query, Expense.class)
                .getResultList();

        return result.stream().map(Expense::getDtoObject).collect(Collectors.toList());
    }
}
