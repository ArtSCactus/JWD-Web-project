package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.FacultyDao;
import com.epam.model.dao.types.SpecialtyDao;
import com.epam.model.dto.university.Faculty;
import com.epam.model.dto.university.Specialty;
import com.epam.model.dto.university.University;
import exception.dao.DaoException;
import exception.service.ServiceException;

import java.util.List;
import java.util.Optional;

public class UniversityService {
    /**Initializes university structure.
     *
     * In process, loading all faculties and specialties from the database. After that,
     * loads specialties to faculties list, by comparing specialty field {@code facultyId} and {@code id}
     * field in faculty.
     *
     * @return {@code ArrayList<Faculty>}
     * @throws ServiceException
     */
    public List<Faculty> initStructure() throws ServiceException {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            FacultyDao accountDao = dao.getFacultyDao();
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            List<Faculty> faculties = accountDao.getAll();
            List<Specialty> specialties = specialtyDao.getAll();
            for (Faculty faculty : faculties) {
                for (Specialty specialty : specialties) {
                    if (specialty.getFacultyId().equals(faculty.getId())) {
                        faculty.addSpecialty(specialty);
                    }
                }
            }
            return faculties;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

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

    public Optional<Specialty> getSpecialtyById(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
           return specialtyDao.getById(id);
        }
    }

    public String getSpecialtyNameById(Long id){
        Optional<Specialty> specialtyOptional =getSpecialtyById(id);
        if (specialtyOptional.isPresent()){
            return specialtyOptional.get().getName();
        } else {
            throw new ServiceException("No such specialty with id: "+id);
        }
    }

    public String getFacultyNameById(Long id){
        return getFacultyById(id).getName();
    }

    public List<Faculty> getFaculties(){
        return University.getInstance().getFaculties();
    }

    public Long getFacultyIdByName(String name){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            FacultyDao facultyDao = dao.getFacultyDao();
           Optional<Faculty> facultyOptional = facultyDao.getByName(name);
            return facultyOptional.map(Faculty::getId).orElse(null);
        }
    }

    public Long getSpecialtyIdByName(String name){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            Optional<Specialty> specialtyOptional = specialtyDao.getByName(name);
            return specialtyOptional.map(Specialty::getId).orElse(null);
        }
    }

    public List<Specialty> getAllSpecialties(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            return specialtyDao.getAll();
        }
    }

}
