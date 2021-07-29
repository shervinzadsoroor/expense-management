package com.expenseAndDebt.core.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseDTO {
    private Long id;
    private Date createdDate;
    private String createdDateSolarString;
    private Boolean isDeleted;
    private Boolean isEnabled;
    private String description;
}
