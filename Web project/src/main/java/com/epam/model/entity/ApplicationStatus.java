package com.epam.model.entity;

public enum ApplicationStatus {
    DECLINED("denied"), ACCEPTED("accepted"), WAITING("waiting");

    ApplicationStatus(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApplicationStatus{" +
                "status='" + message + '\'' +
                '}';
    }


}
