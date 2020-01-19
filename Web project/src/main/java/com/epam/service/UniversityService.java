package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.FacultyDao;
import com.epam.model.dao.types.SpecialtyDao;
import com.epam.model.entity.Faculty;
import com.epam.model.entity.Specialty;
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
    public List<Faculty> initFaculties() throws ServiceException {
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
}
