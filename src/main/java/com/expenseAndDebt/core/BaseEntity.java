package com.expenseAndDebt.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

    @Column(name = "DESCRIPTION")
    private Long description;
}
