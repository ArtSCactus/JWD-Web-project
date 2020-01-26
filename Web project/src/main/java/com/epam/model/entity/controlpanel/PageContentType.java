package com.epam.model.entity.controlpanel;

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
