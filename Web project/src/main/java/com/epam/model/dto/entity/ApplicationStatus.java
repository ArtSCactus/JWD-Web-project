package com.epam.model.dto.entity;

public enum ApplicationStatus {
    REJECTED("rejected"),
    ACCEPTED("accepted"),
    WAITING("waiting"),
    CANCELLED("cancelled");

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
