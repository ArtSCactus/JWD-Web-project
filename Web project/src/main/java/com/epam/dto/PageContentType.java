package com.epam.dto;

public enum PageContentType {
    APPLICATIONS("applications"),
    ACCOUNTS("accounts"),
    STUDENTS("students"),
    ADMISSIONS("admissions");
    String stringValue;

    PageContentType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
