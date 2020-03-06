package com.epam.model.dto.entity;

import com.epam.model.dto.Identifiable;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Student implements Identifiable, Serializable {
    private Long id;
    private Long accountId;
    private Long facultyId;
    private Long specialtyId;
    private Date enrollmentDate;
    private StudentStatus status;
    /*
    Student name for a table, to make table content more user-friendly.
    * */
    private String name;
    /*
   Student name for a table, to make table content more user-friendly.
   * */
    private String surname;
    /*
   Student name for a table, to make table content more user-friendly.
   * */
    private String patronymic;

    private Student() {

    }

    public Student(Long id, Long accountId, Long facultyId,
                   Long specialtyId, Date enrollmentDate, StudentStatus status) {
        this.id = id;
        this.accountId = accountId;
        this.facultyId = facultyId;
        this.specialtyId = specialtyId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Student(Long id, Long accountId,
                   Long facultyId, Long specialtyId, Date enrollmentDate,
                   StudentStatus status, String name, String surname, String patronymic) {
        this.id = id;
        this.accountId = accountId;
        this.facultyId = facultyId;
        this.specialtyId = specialtyId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public static class Builder {
        private Student obj;

        public Builder() {
            obj = new Student();
        }

        public Builder withId(Long id){
            obj.id = id;
            return this;
        }

        public Builder withAccountId(Long id){
            obj.accountId = id;
            return this;
        }

        public Builder withFacultyId(Long id){
            obj.facultyId = id;
            return this;
        }
        public Builder withSpecialtyId(Long id){
            obj.specialtyId = id;
            return this;
        }

        public Builder withEnrollmentDate(Date date){
            obj.enrollmentDate = date;
            return this;
        }

        public Builder withStudentStatus(StudentStatus status){
            obj.status = status;
            return this;
        }

        public Builder withName(String name){
            obj.name = name;
            return this;
        }

        public Builder withSurname(String surname){
            obj.surname = surname;
            return this;
        }

        public Builder withPatronymic(String patronymic){
            obj.patronymic = patronymic;
            return this;
        }

        public Student build(){
            return obj;
        }
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
                Objects.equals(getEnrollmentDate(), student.getEnrollmentDate()) &&
                getStatus() == student.getStatus() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getSurname(), student.getSurname()) &&
                Objects.equals(getPatronymic(), student.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getFacultyId(), getSpecialtyId(), getEnrollmentDate(), getStatus(), getName(), getSurname(), getPatronymic());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", facultyId=" + facultyId +
                ", specialtyId=" + specialtyId +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
