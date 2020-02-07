package com.epam.model.dto.entity;

import java.sql.Date;
import java.util.Objects;

public class Admission {
    private Long id;
    private Date start;
    private Date end;
    private Long facultyId;
    private Long specialtyId;
    private int amountOfStudents;

    private boolean isActive;

    private Admission() {
    }

    public Admission(Long id, Date start, Date end, Long facultyId,
                     Long specialtyId, boolean isActive, int amountOfStudents) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.facultyId = facultyId;
        this.specialtyId = specialtyId;
        this.isActive = isActive;
        this.amountOfStudents = amountOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setStatus(boolean isActive) {
        this.isActive = isActive;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
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

    public static class Builder {
        private Admission admission;

        public Builder() {
            admission = new Admission();
        }

        public Builder withId(Long id) {
            admission.id = id;
            return this;
        }

        public Builder withStart(Date start) {
            admission.start = start;
            return this;
        }

        public Builder withEnd(Date end) {
            admission.end = end;
            return this;
        }

        public Builder withAmountOfStudents(int amountOfStudents) {
            admission.amountOfStudents = amountOfStudents;
            return this;
        }

        public Builder withFacultyId(Long id) {
            admission.facultyId = id;
            return this;
        }

        public Builder withSpecialtyId(Long id) {
            admission.specialtyId = id;
            return this;
        }

        public Builder withStatus(boolean isActive) {
            admission.isActive = isActive;
            return this;
        }

        public Admission build() {
            return admission;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admission)) return false;
        Admission admission = (Admission) o;
        return getAmountOfStudents() == admission.getAmountOfStudents() &&
                isActive() == admission.isActive() &&
                Objects.equals(getId(), admission.getId()) &&
                Objects.equals(getStart(), admission.getStart()) &&
                Objects.equals(getEnd(), admission.getEnd()) &&
                Objects.equals(getFacultyId(), admission.getFacultyId()) &&
                Objects.equals(getSpecialtyId(), admission.getSpecialtyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStart(), getEnd(), getFacultyId(), getSpecialtyId(), getAmountOfStudents(), isActive());
    }

    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", facultyId=" + facultyId +
                ", specialtyId=" + specialtyId +
                ", amountOfStudents=" + amountOfStudents +
                ", status=" + isActive +
                '}';
    }


}
