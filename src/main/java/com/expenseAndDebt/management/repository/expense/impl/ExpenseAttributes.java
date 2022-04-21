package com.expenseAndDebt.management.repository.expense.impl;

import com.expenseAndDebt.management.model.domainmodel.Expense;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Expense.class)
public class ExpenseAttributes {

    public static volatile SingularAttribute<Expense, Long> amount;
    public static volatile SingularAttribute<Expense, Long> biType;

}
