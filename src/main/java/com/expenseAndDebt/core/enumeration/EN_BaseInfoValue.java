package com.expenseAndDebt.core.enumeration;

public enum EN_BaseInfoValue {

    HOME_SHOPPING(1L),
    CAR_REPAIR(2L),
    RESTAURANT_AND_COFFEE_SHOP(3L),
    TRAVEL(4L),
    HOME_APPLIANCES_REPAIR(5L);

    private final Long id;

    EN_BaseInfoValue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
