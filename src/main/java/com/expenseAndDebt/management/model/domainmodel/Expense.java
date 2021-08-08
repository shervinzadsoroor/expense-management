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

    @Column(name = "BI_TYPE")
    private Long biType;

    @Column(name = "IS_PAID")
    private Boolean isPaid;

    @Column(name = "DATE_FOR_PAY")
    private Date dateForPay;

    public Expense() {
        super();
    }

    @Override
    public void getDomainObject(ExpenseDTO dto) {
        this.id = dto.getId();
        this.version = dto.getVersion();
        this.description = dto.getDescription();
        this.amount = dto.getAmount();
        this.biType = dto.getBiType();
        this.isPaid = dto.getIsPaid();
        this.dateForPay = dto.getDateForPay();
    }

    @Override
    public ExpenseDTO getDtoObject() {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(this.id);
        dto.setVersion(this.version);
        dto.setCreatedDate(this.createdDate);
        dto.setIsDeleted(this.isDeleted);
        dto.setIsEnabled(this.isEnabled);
        dto.setDescription(this.description);
        dto.setAmount(this.getAmount());
        dto.setBiType(this.biType);
        dto.setIsPaid(this.isPaid);
        dto.setDateForPay(this.dateForPay);
        return dto;
    }
}
