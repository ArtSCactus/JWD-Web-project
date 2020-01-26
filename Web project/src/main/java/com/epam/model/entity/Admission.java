package com.epam.model.entity;

import java.sql.Date;
import java.util.Objects;

public class Admission {
    private Long id;
    private Date start;
    private Date end;
    private String description;
    private boolean status;

    public Admission(Long id, Date start, Date end, String description, boolean status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admission)) return false;
        Admission admission = (Admission) o;
        return isStatus() == admission.isStatus() &&
                Objects.equals(getId(), admission.getId()) &&
                Objects.equals(getStart(), admission.getStart()) &&
                Objects.equals(getEnd(), admission.getEnd()) &&
                Objects.equals(getDescription(), admission.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStart(), getEnd(), getDescription(), isStatus());
    }

    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
