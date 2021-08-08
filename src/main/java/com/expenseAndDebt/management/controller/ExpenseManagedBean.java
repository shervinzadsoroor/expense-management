package com.expenseAndDebt.management.controller;

import com.expenseAndDebt.core.enumeration.EN_BaseInfoGroup;
import com.expenseAndDebt.core.managedbean.BaseManagedBean;
import com.expenseAndDebt.core.model.BaseInfoValueDTO;
import com.expenseAndDebt.core.service.IBaseInfoValueService;
import com.expenseAndDebt.management.lazydatamodel.ExpenseLazyDataModel;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.service.IExpenseService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ExpenseManagedBean extends BaseManagedBean {

    @Setter @Getter
    private ExpenseDTO expenseDTO;

    @Getter
    private ExpenseLazyDataModel expenseLazyDataModel;

    @Getter
    private List<BaseInfoValueDTO> expenseTypesBiDtoList;

    private final IBaseInfoValueService iBaseInfoValueService;

    private final IExpenseService iExpenseService;

    public ExpenseManagedBean(IBaseInfoValueService iBaseInfoValueService, IExpenseService iExpenseService) {
        this.iBaseInfoValueService = iBaseInfoValueService;
        this.iExpenseService = iExpenseService;
    }

    public void init() {
        expenseDTO = new ExpenseDTO();
        expenseLazyDataModel = new ExpenseLazyDataModel(iExpenseService);
        expenseTypesBiDtoList = iBaseInfoValueService.getAllByBaseInfoGroup(EN_BaseInfoGroup.EXPENSE.getId());
    }

    public void save() {
        try {
            iExpenseService.saveByDto(expenseDTO);
            showInfo("ثبت با موفقیت انجام شد", null);
        } catch (Exception e) {
            e.printStackTrace();
            showError("ثبت انجام نشد!" , null);
        }

    }
}
