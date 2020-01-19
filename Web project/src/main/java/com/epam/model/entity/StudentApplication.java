package com.epam.model.entity;

import java.sql.Date;
import java.util.Objects;

public class StudentApplication implements Identifiable {
    private Long id;
    private Long facultyId;
    private Long accountId;
    private Long admissionId;
    private Long specialtyId;
    private boolean isAccepted;
    private Date filingDate;

    public StudentApplication(Long id, Long facultyId, Long accountId,
                              Long admissionId, Long specialtyId, boolean isAccepted, Date filingDate) {
        this.id = id;
        this.facultyId = facultyId;
        this.accountId = accountId;
        this.admissionId = admissionId;
        this.specialtyId = specialtyId;
        this.isAccepted = isAccepted;
        this.filingDate = filingDate;
    }

    public StudentApplication(Long facultyId, Long accountId,
                              Long admissionId, Long specialtyId, boolean isAccepted, Date filingDate) {
        this.facultyId = facultyId;
        this.accountId = accountId;
        this.admissionId = admissionId;
        this.specialtyId = specialtyId;
        this.isAccepted = isAccepted;
        this.filingDate = filingDate;
    }

    private StudentApplication(){
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

    public Long getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Long admissionId) {
        this.admissionId = admissionId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public static class Builder{
        private StudentApplication obj;

        public Builder() {
            obj=new StudentApplication();
        }

        public Builder withId(Long id){
            obj.id=id;
            return this;
        }

        public Builder withFacultyId(Long id){
            obj.facultyId=id;
            return this;
        }

        public Builder withSpecialtyId(Long id){
            obj.specialtyId=id;
            return this;
        }

        public Builder withAccountId(Long id){
            obj.accountId=id;
            return this;
        }

        public Builder withAdmissionId(Long id){
            obj.admissionId=id;
            return this;
        }

        public Builder withStatus(boolean isAccepted){
            obj.isAccepted=isAccepted;
            return this;
        }

        public Builder withDate(Date filingDate){
            obj.filingDate=filingDate;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentApplication)) return false;
        StudentApplication that = (StudentApplication) o;
        return isAccepted() == that.isAccepted() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFacultyId(), that.getFacultyId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getAdmissionId(), that.getAdmissionId()) &&
                Objects.equals(getSpecialtyId(), that.getSpecialtyId()) &&
                Objects.equals(getFilingDate(), that.getFilingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFacultyId(), getAccountId(), getAdmissionId(), getSpecialtyId(), isAccepted(), getFilingDate());
    }

    @Override
    public String toString() {
        return "StudentApplication{" +
                "id=" + id +
                ", facultyId=" + facultyId +
                ", accountId=" + accountId +
                ", admissionId=" + admissionId +
                ", specialtyId=" + specialtyId +
                ", isAccepted=" + isAccepted +
                ", filingDate=" + filingDate +
                '}';
    }
}
