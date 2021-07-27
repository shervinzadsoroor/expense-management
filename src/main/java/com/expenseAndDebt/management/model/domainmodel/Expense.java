package com.expenseAndDebt.management.model.domainmodel;

import com.expenseAndDebt.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "EXPENSE")
public class Expense extends BaseEntity {

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "TYPE")
    private Long typeBiValue;

    @Column(name = "IS_PAID")
    private Boolean isPaid;

    @Column(name = "DATE_FOR_PAY")
    private Date dateForPay;

}
