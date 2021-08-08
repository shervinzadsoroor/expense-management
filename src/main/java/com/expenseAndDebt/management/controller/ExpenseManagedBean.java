package com.expenseAndDebt.management.controller;

import com.expenseAndDebt.core.managedbean.BaseManagedBean;
import com.expenseAndDebt.management.lazydatamodel.ExpenseLazyDataModel;
import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.service.IExpenseService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ExpenseManagedBean extends BaseManagedBean {

    @Setter @Getter
    private ExpenseDTO expenseDTO;

    @Getter
    private ExpenseLazyDataModel expenseLazyDataModel;

//    private List<ExpenseDTO> expenseDTOList = Arrays

    private final IExpenseService iExpenseService;

    public ExpenseManagedBean(IExpenseService iExpenseService) {
        this.iExpenseService = iExpenseService;
    }

    public void init() {
        expenseDTO = new ExpenseDTO();
        expenseLazyDataModel = new ExpenseLazyDataModel(iExpenseService);
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
