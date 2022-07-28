package com.example.swaggerapp.enums;

public enum GroupName {
    EMPLOYEE_CRUD("Xodimlarni boshqarish"),
    CUSTOMER_CRUD("Mijozlarni boshqarish");

    private String nameUz;

    GroupName(String nameUz) {
        this.nameUz = nameUz;
    }
}
