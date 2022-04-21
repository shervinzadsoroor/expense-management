package com.expenseAndDebt.management.model.dto;

import com.expenseAndDebt.core.model.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExpenseDTO extends BaseDTO {

    private Long id;
    private Long version;
    private Date createdDate;
    private Boolean isDeleted;
    private Boolean isEnabled;
    private String description;
    private Long amount;
    private Long biType;
    private String biTypeTitle;
    private Boolean isPaid;
    private Date dateForPay;
}
