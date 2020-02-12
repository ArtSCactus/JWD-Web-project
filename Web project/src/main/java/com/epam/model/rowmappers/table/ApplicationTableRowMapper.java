package com.epam.model.rowmappers.table;

import com.epam.model.dto.entity.Application;
import com.epam.model.dto.entity.ApplicationStatus;
import com.epam.model.rowmappers.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class ApplicationTableRowMapper implements RowMapper<Application> {
    private static final String ID_COLUMN = "id";
    private static final String FACULTY_ID_COLUMN = "facultyId";
    private static final String SPECIALTY_ID_COLUMN = "specialtyId";
    private static final String ACCOUNT_ID_COLUMN = "accountId";
    private static final String STATUS_COLUMN = "status";
    private static final String FILING_DATE_COLUMN = "date";
    private static final String NAME_COLUMN = "name";
    private static final String SURNAME_COLUMN = "surname";
    private static final String PATRONYMIC_COLUMN = "patronymic";
    private static final String SPECIALTY_COLUMN = "specialties.name_en";
    private static final String FACULTY_COLUMN = "faculties.name";
    @Override
    public Application map(ResultSet resultSet) throws SQLException {
        return new Application.Builder()
                .withId(resultSet.getLong(ID_COLUMN))
                .withFacultyId(resultSet.getLong(FACULTY_ID_COLUMN))
                .withSpecialtyId(resultSet.getLong(SPECIALTY_ID_COLUMN))
                .withAccountId(resultSet.getLong(ACCOUNT_ID_COLUMN))
                .withStatus(ApplicationStatus.valueOf(resultSet.getString(STATUS_COLUMN).toUpperCase()))
                .withDate(resultSet.getDate(FILING_DATE_COLUMN))
                .withName(resultSet.getString(NAME_COLUMN))
                .withSurname(resultSet.getString(SURNAME_COLUMN))
                .withPatronymic(resultSet.getString(PATRONYMIC_COLUMN))
                .withFacultyName(resultSet.getString(FACULTY_COLUMN))
                .withSpecialtyName(resultSet.getString(SPECIALTY_COLUMN))
                .build();
    }
}
