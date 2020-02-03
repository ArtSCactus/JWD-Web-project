package com.epam.service;

import com.epam.model.dto.university.Faculty;
import com.epam.model.dto.university.University;
import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.FacultyDao;

import java.util.List;
import java.util.Optional;

public class FacultyService {
    public Faculty getFacultyById(Long id){
        University university = University.getInstance();
        List<Faculty> faculties = university.getFaculties();
        for (Faculty faculty : faculties){
            if (faculty.getId().equals(id)){
                return faculty;
            }
        }
        return null;
    }
    public String getFacultyNameById(Long id){
        return getFacultyById(id).getName();
    }

    public List<Faculty> getAllFaculties(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            FacultyDao facultyDao = dao.getFacultyDao();
            return facultyDao.getAll();
        }
    }

    public Long getFacultyIdByName(String name){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            FacultyDao facultyDao = dao.getFacultyDao();
            Optional<Faculty> facultyOptional = facultyDao.getByName(name);
            return facultyOptional.map(Faculty::getId).orElse(null);
        }
    }
}
