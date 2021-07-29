package com.expenseAndDebt.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity<E, D extends BaseDTO> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @Column(name = "IS_DELETED")
    protected Boolean isDeleted;

    @Column(name = "IS_ENABLED")
    protected Boolean isEnabled;

    @Column(name = "DESCRIPTION")
    protected String description;

    public void getDomainObject(D dto) {
    }

    public D getDtoObject() {
        return null;
    }
}
