package com.expenseAndDebt.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

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

    @Version
    protected Long version;

    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @Column(name = "IS_DELETED", columnDefinition = "boolean default false")
    protected Boolean isDeleted;

    @Column(name = "IS_ENABLED", columnDefinition = "boolean default true")
    protected Boolean isEnabled;

    @Column(name = "DESCRIPTION")
    protected String description;

    public BaseEntity() {
        this.createdDate = new Date();
        this.isDeleted = Boolean.FALSE;
        this.isEnabled = Boolean.TRUE;
    }

    public void getDomainObject(D dto) {
    }

    public D getDtoObject() {
        return null;
    }
}
