package com.epam.model.rowmappers;

import com.epam.model.dto.entity.Admission;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmissionRowMapper implements RowMapper<Admission> {
    private static final String ID_COL_NAME = "id";
    private static final String START_COL_NAME = "start";
    private static final String END_COL_NAME = "end";
    private static final String STATUS_COL_NAME = "status";
    private static final String STUDENTS_AMOUNT_COL_NAME="required_students";
    private static final String FACULTY_ID_COL_NAME = "facultyId";
    private static final String SPECIALTY_ID_COL_NAME = "specialtyId";

    @Override
    public Admission map(ResultSet resultSet) throws SQLException {
        return new Admission(resultSet.getLong(ID_COL_NAME),
                resultSet.getDate(START_COL_NAME),
                resultSet.getDate(END_COL_NAME),
                resultSet.getLong(FACULTY_ID_COL_NAME),
                resultSet.getLong(SPECIALTY_ID_COL_NAME),
                resultSet.getBoolean(STATUS_COL_NAME),
                resultSet.getInt(STUDENTS_AMOUNT_COL_NAME));
    }
}
