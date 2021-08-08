package com.expenseAndDebt.core.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseInfoValueDTO extends BaseDTO {
    private Long code;
    private String title;
    private String englishTitle;
}
