package com.example.swaggerapp.enums;

public enum PermissionName {
    ADD_EMPLOYEE("Xodim qo'shish", GroupName.EMPLOYEE_CRUD),
    ADD_CUSTOMER("Mijoz qo'shish", GroupName.CUSTOMER_CRUD),
    EDIT_EMPLOYEE("Xodimni tahrirlash", GroupName.EMPLOYEE_CRUD),
    EDIT_CUSTOMER("Mijozni tahrirlash", GroupName.CUSTOMER_CRUD),
    DELETE_EMPLOYEE("Xodimni o'chirish", GroupName.EMPLOYEE_CRUD),
    DELETE_CUSTOMER("Mijozni o'chirish", GroupName.CUSTOMER_CRUD),
    GET_EMPLOYEE("Xodimni olish", GroupName.EMPLOYEE_CRUD),
    GET_CUSTOMER("Mijozni olish", GroupName.CUSTOMER_CRUD);

    private String nameUz;
    private GroupName groupName;

    PermissionName(String uzName, GroupName groupName) {
        this.nameUz = uzName;
        this.groupName = groupName;
    }
}
