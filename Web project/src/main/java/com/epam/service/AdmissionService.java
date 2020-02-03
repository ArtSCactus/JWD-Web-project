package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.AdmissionDao;
import com.epam.model.dto.entity.Admission;
import exception.service.ServiceException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AdmissionService {
    public void startAdmission(Long facultyId, Long specialtyId, Date end, int limit) {
        Admission admission = new Admission.Builder()
                .withId(null)
                .withFacultyId(facultyId)
                .withSpecialtyId(specialtyId)
                .withStart(Date.valueOf(LocalDate.now()))
                .withEnd(end)
                .withAmountOfStudents(limit)
                .withStatus(true)
                .build();
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AdmissionDao admissionDao = dao.getAdmissionDao();
            admissionDao.save(admission);
        }
    }

    public void endAdmission(Long id) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AdmissionDao admissionDao = dao.getAdmissionDao();
            Optional<Admission> admissionOptional = admissionDao.getById(id);
            if (admissionOptional.isPresent()) {
                Admission admission = admissionOptional.get();
                admission.setStatus(false);
                admissionDao.save(admission);
            } else {
                throw new ServiceException("Admission with id " + id + " not found");
            }
        }
    }

    public List<Admission> getAdmissionList() {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AdmissionDao admissionDao = dao.getAdmissionDao();
            return admissionDao.getAll();
        }
    }

    public Optional<Admission> getAdmissionById(Long id) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AdmissionDao admissionDao = dao.getAdmissionDao();
            return admissionDao.getById(id);
        }
    }

    public void updateAdmission(Admission admission) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AdmissionDao admissionDao = dao.getAdmissionDao();
            admissionDao.save(admission);
        }
    }

}
