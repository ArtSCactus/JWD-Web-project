package com.epam.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Specialty implements Identifiable, Serializable {
    public static final String TABLE_NAME = "specialties";
    private Long id;
    private String name;
    private String description;
    private Long facultyId;

    public Specialty() {
    }

    public Specialty(Long id, Long facultyId, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facultyId=facultyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(getId(), specialty.getId()) &&
                Objects.equals(getName(), specialty.getName()) &&
                Objects.equals(getDescription(), specialty.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
