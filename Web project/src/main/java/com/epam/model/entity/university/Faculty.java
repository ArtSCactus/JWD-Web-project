package com.epam.model.entity.university;

import com.epam.model.entity.Identifiable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Faculty implements Identifiable, Serializable {
    public static final String TABLE_NAME = "faculties";
    private Long id;
    private String name;
    private String description;
    private List<Specialty> specialties;

    public Faculty() {
        id = 0L;
        name="";
        description="";
        specialties = new ArrayList<>();
    }

    public Faculty(Long id, String name, String description, List<Specialty> specialties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specialties = specialties;
    }

    public Faculty(Long id, String name, String description, Specialty... specialties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specialties = Arrays.asList(specialties);
    }

    public Faculty(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specialties = new ArrayList<>();
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

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public void addSpecialty(Specialty specialty){
        specialties.add(specialty);
    }
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(getName(), faculty.getName()) &&
                Objects.equals(getDescription(), faculty.getDescription()) &&
                Objects.equals(getSpecialties(), faculty.getSpecialties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getSpecialties());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", specialties=" + specialties +
                '}';
    }
}
