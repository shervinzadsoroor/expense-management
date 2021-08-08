package com.expenseAndDebt.core.enumeration;

public enum EN_BaseInfoGroup {
    EXPENSE(1L);

    private final Long id;

    EN_BaseInfoGroup(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
