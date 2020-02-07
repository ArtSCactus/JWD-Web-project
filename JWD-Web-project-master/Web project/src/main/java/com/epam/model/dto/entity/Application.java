package com.epam.model.dto.entity;

import com.epam.model.dto.Identifiable;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Application implements Identifiable, Serializable {
    private Long id;
    private Long facultyId;
    private Long accountId;
    private Long specialtyId;
    private ApplicationStatus status;
    private Date filingDate;

    public Application(Long id, Long facultyId, Long accountId,
                       Long specialtyId, ApplicationStatus status, Date filingDate) {
        this.id = id;
        this.facultyId = facultyId;
        this.accountId = accountId;
        this.specialtyId = specialtyId;
        this.status = status;
        this.filingDate = filingDate;
    }

    public Application(Long facultyId, Long accountId,
                       Long specialtyId, ApplicationStatus status, Date filingDate) {
        this.facultyId = facultyId;
        this.accountId = accountId;
        this.specialtyId = specialtyId;
        this.status = status;
        this.filingDate = filingDate;
    }

    private Application(){
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public static class Builder {
        private Application obj;

        public Builder() {
            obj = new Application();
        }

        public Builder withId(Long id) {
            obj.id = id;
            return this;
        }

        public Builder withFacultyId(Long id) {
            obj.facultyId = id;
            return this;
        }

        public Builder withSpecialtyId(Long id) {
            obj.specialtyId = id;
            return this;
        }

        public Builder withAccountId(Long id) {
            obj.accountId = id;
            return this;
        }

        public Builder withStatus(ApplicationStatus isAccepted) {
            obj.status = isAccepted;
            return this;
        }

        public Builder withDate(Date filingDate) {
            obj.filingDate = filingDate;
            return this;
        }

        public Application build() {
            return obj;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;
        Application that = (Application) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFacultyId(), that.getFacultyId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getSpecialtyId(), that.getSpecialtyId()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getFilingDate(), that.getFilingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFacultyId(), getAccountId(), getSpecialtyId(), getStatus(), getFilingDate());
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", facultyId=" + facultyId +
                ", accountId=" + accountId +
                ", specialtyId=" + specialtyId +
                ", status=" + status +
                ", filingDate=" + filingDate +
                '}';
    }
}
