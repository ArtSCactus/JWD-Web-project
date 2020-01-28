package com.epam.dto.entity;

import com.epam.dto.Identifiable;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Student implements Identifiable, Serializable {
    private Long id;
    private Long accountId;
    private Long facultyId;
    private Long specialtyId;
    private Date enrollmentDate;

    public Student(Long id, Long accountId, Long facultyId,
                   Long specialtyId, Date enrollmentDate) {
        this.id = id;
        this.accountId = accountId;
        this.facultyId = facultyId;
        this.specialtyId = specialtyId;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) &&
                Objects.equals(getAccountId(), student.getAccountId()) &&
                Objects.equals(getFacultyId(), student.getFacultyId()) &&
                Objects.equals(getSpecialtyId(), student.getSpecialtyId()) &&
                Objects.equals(getEnrollmentDate(), student.getEnrollmentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getFacultyId(), getSpecialtyId(), getEnrollmentDate());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", facultyId=" + facultyId +
                ", specialtyId=" + specialtyId +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
