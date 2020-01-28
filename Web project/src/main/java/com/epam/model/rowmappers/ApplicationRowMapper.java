package com.epam.model.rowmappers;

import com.epam.dto.entity.Application;
import com.epam.dto.entity.ApplicationStatus;
import exceptions.dao.DaoException;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationRowMapper implements RowMapper<Application> {
    private static final String ID_COLUMN = "id";
    private static final String FACULTY_ID_COLUMN = "facultyId";
    private static final String SPECIALTY_ID_COLUMN = "specialtyId";
    private static final String ACCOUNT_ID_COLUMN = "accountId";
    private static final String STATUS_COLUMN = "status";
    private static final String FILING_DATE_COLUMN = "date";

    @Override
    public Application map(ResultSet resultSet) throws SQLException {
        return new Application.Builder()
                .withId(resultSet.getLong(ID_COLUMN))
                .withFacultyId(resultSet.getLong(FACULTY_ID_COLUMN))
                .withSpecialtyId(resultSet.getLong(SPECIALTY_ID_COLUMN))
                .withAccountId(resultSet.getLong(ACCOUNT_ID_COLUMN))
                .withStatus(ApplicationStatus.valueOf(resultSet.getString(STATUS_COLUMN).toUpperCase()))
                .withDate(resultSet.getDate(FILING_DATE_COLUMN))
                .build();
    }

    public Long mapAdmissionResult(ResultSet resultSet){
        try {
            return  resultSet.getLong(ACCOUNT_ID_COLUMN);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
