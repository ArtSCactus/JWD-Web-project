package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.ApplicationDao;
import com.epam.model.entity.Application;
import com.epam.model.entity.ApplicationStatus;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ApplicationService {

    public void apply(Long facultyId, Long specialtyId, Long accountId) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao appDao = dao.getApplicationDao();
            appDao.save(new Application.Builder().withAccountId(accountId)
                    .withFacultyId(facultyId)
                    .withSpecialtyId(specialtyId)
                    .withStatus(ApplicationStatus.WAITING)
                    .withDate(Date.valueOf(LocalDate.now()))
                    .build());
        }
    }

    public List<Application> getApplicationsList(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            ApplicationDao applicationDao = dao.getApplicationDao();
            return applicationDao.getAll();
        }
    }
}
