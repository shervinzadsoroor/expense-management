package com.expenseAndDebt.management.controller;

import com.expenseAndDebt.core.enumeration.EN_BaseInfoGroup;
import com.expenseAndDebt.core.managedbean.BaseManagedBean;
import com.expenseAndDebt.core.model.BaseInfoValueDTO;
import com.expenseAndDebt.core.service.IBaseInfoValueService;
import com.expenseAndDebt.management.lazydatamodel.ExpenseLazyDataModel;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.service.IExpenseService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ManagedBean
@ViewScoped
public class ExpenseManagedBean extends BaseManagedBean {

    @Setter @Getter
    private ExpenseDTO expenseDTO;

    @Setter @Getter
    private ExpenseDTO searchDto;

    @Setter @Getter
    private List<ExpenseDTO> expenseDTOList;

    @Getter @Setter
    private ExpenseLazyDataModel expenseLazyDataModel;

    @Getter
    private List<BaseInfoValueDTO> expenseTypesBiDtoList;

    private final IBaseInfoValueService iBaseInfoValueService;

    private final IExpenseService iExpenseService;

    public ExpenseManagedBean(IBaseInfoValueService iBaseInfoValueService, IExpenseService iExpenseService) {
        this.iBaseInfoValueService = iBaseInfoValueService;
        this.iExpenseService = iExpenseService;
    }

    public void init() throws Exception {
        expenseDTO = new ExpenseDTO();
        getAllExpenses();
        expenseLazyDataModel = new ExpenseLazyDataModel(iExpenseService, searchDto);
        expenseTypesBiDtoList = iBaseInfoValueService.getAllByBaseInfoGroup(EN_BaseInfoGroup.EXPENSE.getId());
    }

    public void save() {
        try {
            iExpenseService.saveByDto(expenseDTO);
            getAllExpenses();
            showInfo("ثبت با موفقیت انجام شد", null);
        } catch (Exception e) {
            e.printStackTrace();
            showError("ثبت انجام نشد!" , null);
        }
    }

    public void getAllExpenses() throws Exception {
        this.expenseDTOList = iExpenseService.getAllMappedList();
    }
}
