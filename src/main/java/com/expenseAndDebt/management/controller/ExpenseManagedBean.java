package com.expenseAndDebt.management.controller;

import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import com.expenseAndDebt.management.service.IExpenseService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class ExpenseManagedBean {

    @Setter @Getter
    private ExpenseDTO expenseDTO;

    private final IExpenseService iExpenseService;

    public ExpenseManagedBean(IExpenseService iExpenseService) {
        this.iExpenseService = iExpenseService;
    }

    public void init() {
        expenseDTO = new ExpenseDTO();
    }

    public void save() {
        iExpenseService.saveByDto(expenseDTO);
    }
}
