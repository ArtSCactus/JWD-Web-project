package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.FacultyDao;
import com.epam.model.dto.university.Faculty;
import exception.service.ServiceException;

import java.util.List;
import java.util.Optional;

public class FacultyService {
    public Faculty getFacultyById(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            FacultyDao facultyDao = dao.getFacultyDao();
            Optional<Faculty> specialty = facultyDao.getById(id);
            if (specialty.isPresent()){
                return specialty.get();
            } else {
                throw new ServiceException("No such faculty with id: "+id);
            }
        }
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
