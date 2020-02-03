package com.epam.service;

import com.epam.model.dto.university.Specialty;
import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.SpecialtyDao;
import exception.service.ServiceException;

import java.util.List;
import java.util.Optional;

public class SpecialtyService {
    public Long getSpecialtyIdByName(String name) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            Optional<Specialty> specialtyOptional = specialtyDao.getByName(name);
            return specialtyOptional.map(Specialty::getId).orElse(null);
        }
    }

    public List<Specialty> getAllSpecialties() {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            return specialtyDao.getAll();
        }
    }

    public String getSpecialtyNameById(Long id) {
        Optional<Specialty> specialtyOptional = getSpecialtyById(id);
        if (specialtyOptional.isPresent()) {
            return specialtyOptional.get().getName();
        } else {
            throw new ServiceException("No such specialty with id: " + id);
        }
    }

    public Optional<Specialty> getSpecialtyById(Long id) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            SpecialtyDao specialtyDao = dao.getSpecialtyDao();
            return specialtyDao.getById(id);
        }
    }
}
