package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.ApplicationDao;
import com.epam.model.entity.Application;

import java.sql.Date;
import java.time.LocalDate;

public class ApplicationService {

    public void apply(Long facultyId, Long specialtyId, Long accountId) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            ApplicationDao appDao = dao.getApplicationDao();
            appDao.save(new Application.Builder().withAccountId(accountId)
                    .withFacultyId(facultyId)
                    .withSpecialtyId(specialtyId)
                    .withStatus(false)
                    .withDate(Date.valueOf(LocalDate.now()))
                    .build());
        }
    }
}
