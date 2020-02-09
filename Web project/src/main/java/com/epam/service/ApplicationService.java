package com.epam.service;

import com.epam.model.dto.entity.Admission;
import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.ApplicationDao;
import com.epam.model.dto.entity.Application;
import com.epam.model.dto.entity.ApplicationStatus;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ApplicationService {
    /**
     * Registers new application.
     * <p>
     * Creates new application from incoming parameters and sends it to database.
     *
     * @param facultyId   {@code Long} type id of faculty on which application was submitted.
     * @param specialtyId {@code Long} type id of specialty on which application was submitted.
     * @param accountId   {@code Long} type id of account which submitted the application.
     */
    public void apply(Long facultyId, Long specialtyId, Long accountId) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao appDao = dao.getApplicationDao();
            appDao.save(new Application.Builder()
                    .withAccountId(accountId)
                    .withFacultyId(facultyId)
                    .withSpecialtyId(specialtyId)
                    .withStatus(ApplicationStatus.WAITING)
                    .withDate(Date.valueOf(LocalDate.now()))
                    .build());
        }
    }

    /**
     * Returns list of all applications from database.
     * <p>
     *
     * @return {@code ArrayList()} object with applications.
     */
    public List<Application> getApplicationsList() {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao applicationDao = dao.getApplicationDao();
            return applicationDao.getAll();
        }
    }

    public Optional<Application> getApplicationById(Long id) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao applicationDao = dao.getApplicationDao();
            return applicationDao.getById(id);
        }
    }

    public void update(Application application) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao applicationDao = dao.getApplicationDao();
            applicationDao.save(application);
        }
    }

    public List<Application> getEnrolledApplications(Admission admission){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            ApplicationDao applicationDao = dao.getApplicationDao();
           return applicationDao.getEnrolledApplications(admission);
        }
    }

    public List<Application> getApplicationsByAccountId(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            ApplicationDao applicationDao = dao.getApplicationDao();
            return applicationDao.getByAccountId(id);
        }
    }

    public List<Application> getAppliedApplications(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            ApplicationDao applicationDao = dao.getApplicationDao();
            return applicationDao.getByAccountId(id);
        }
    }
}
