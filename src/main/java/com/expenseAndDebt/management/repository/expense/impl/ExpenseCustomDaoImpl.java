package com.expenseAndDebt.management.repository.expense.impl;

import com.expenseAndDebt.core.repository.BaseCustomDaoImpl;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.repository.expense.IExpenseCustomDao;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExpenseCustomDaoImpl extends BaseCustomDaoImpl implements IExpenseCustomDao {
    @Override
    public List<ExpenseDTO> getLazyDataList(int first, int pageSize, String sortField, SortOrder sortOrder, ExpenseDTO searchDto) {
        String query =
                " select ex.id          as id,\n" +
                        " ex.description as description,\n" +
                        " ex.isDeleted   as isDeleted,\n" +
                        " ex.amount      as amount,\n" +
                        " ex.biType      as biType,\n" +
                        " type.title     as biTypeTitle,\n" +
                        " ex.dateForPay  as dateForPay\n" +
                        " from EXPENSE ex\n" +
                        " inner join BASE_INFO_VALUE type on type.code = ex.biType\n";

        Map<String, Object> params = new HashMap<>();
        return getList(query, params, ExpenseDTO.class);
    }

    @Override
    public List<ExpenseDTO> getAllMappedList() {
        String query = "with baseInfo as (select code, title from base_info_value)" +
                " select " +
                " ex.id                    as id, \n" +
                " ex.description           as description, \n" +
                " ex.is_deleted            as isDeleted, \n" +
                " ex.amount                as amount, \n" +
                " ex.bi_type               as biType, \n" +
                " type.title               as biTypeTitle, \n" +
                " ex.date_for_pay          as dateForPay \n" +
                " from EXPENSE ex" +
                " inner join baseInfo type on type.code = ex.bi_type" +
                " order by ex.date_for_pay desc , ex.id desc ";

        return getList(query, new HashMap<>(), ExpenseDTO.class);
    }
}
