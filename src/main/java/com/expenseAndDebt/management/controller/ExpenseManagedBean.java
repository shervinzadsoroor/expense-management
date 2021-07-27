package com.expenseAndDebt.management.controller;

import com.expenseAndDebt.management.model.domainmodel.Expense;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
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
}
