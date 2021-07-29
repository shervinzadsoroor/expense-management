package com.expenseAndDebt.management.model.domainmodel;

import com.expenseAndDebt.core.model.BaseEntity;
import com.expenseAndDebt.management.model.dto.ExpenseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Setter
@Getter
@Entity(name = "EXPENSE")
public class Expense extends BaseEntity<Expense, ExpenseDTO> {

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "TYPE")
    private Long typeBiValue;

    @Column(name = "IS_PAID")
    private Boolean isPaid;

    @Column(name = "DATE_FOR_PAY")
    private Date dateForPay;

    @Override
    public void getDomainObject(ExpenseDTO dto) {
        this.id = dto.getId();
        this.createdDate = new Date();
        this.isDeleted = dto.getIsDeleted();
        this.isEnabled = dto.getIsEnabled();
        this.description = dto.getDescription();
        this.amount = dto.getAmount();
        this.typeBiValue = dto.getTypeBiValue();
        this.isPaid = dto.getIsPaid();
        this.dateForPay = dto.getDateForPay();
    }

    @Override
    public ExpenseDTO getDtoObject() {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setCreatedDate(this.getCreatedDate());
        dto.setIsDeleted(this.getIsDeleted());
        dto.setIsEnabled(this.getIsEnabled());
        dto.setDescription(this.getDescription());
        dto.setAmount(this.getAmount());
        dto.setTypeBiValue(this.getTypeBiValue());
        dto.setIsPaid(this.getIsPaid());
        dto.setDateForPay(this.getDateForPay());
        return dto;
    }
}
