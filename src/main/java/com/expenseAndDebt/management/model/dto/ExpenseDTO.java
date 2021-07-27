package com.expenseAndDebt.management.model.dto;

import com.expenseAndDebt.core.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExpenseDTO extends BaseDTO {

    private Long id;
    private Date createdDate;
    private Boolean isDeleted;
    private Boolean isEnabled;
    private String description;
    private Long amount;
    private Long typeBiValue;
    private Boolean isPaid;
    private Date dateForPay;
}
