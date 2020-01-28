package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.FacultyDao;
import com.epam.model.dao.types.SpecialtyDao;
import com.epam.dto.university.Faculty;
import com.epam.dto.university.Specialty;
import com.epam.dto.university.University;
import exceptions.dao.DaoException;
import exceptions.service.ServiceException;

import java.util.List;

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

    public Specialty getSpecialtyById(Long id){
        University university = University.getInstance();
        List<Faculty> faculties = university.getFaculties();
        for (Faculty faculty : faculties){
            for (Specialty specialty : faculty.getSpecialties()){
                if (specialty.getId().equals(id)){
                    return specialty;
                }
            }
        }
        return null;
    }

    public String getSpecialtyNameById(Long id){
        return getSpecialtyById(id).getName();
    }

    public String getFacultyNameById(Long id){
        return getFacultyById(id).getName();
    }

    public List<Faculty> getFaculties(){
        return University.getInstance().getFaculties();
    }

}
