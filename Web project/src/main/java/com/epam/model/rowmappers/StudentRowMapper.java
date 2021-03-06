package com.epam.model.rowmappers;

import com.epam.model.dto.entity.Student;
import com.epam.model.dto.entity.StudentStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    private static final String ID_COL_NAME = "id";
    private static final String ACCOUNT_ID_COL_NAME="accountId";
    private static final String FACULTY_ID_COL_NAME="facultyId";
    private static final String SPECIALTY_ID_COL_NAME="specialtyId";
    private static final String ENROLLMENT_DATE_COL_NAME="enrollmentDate";
    private static final String STATUS_COL_NAME="status";

    @Override
    public Student map(ResultSet resultSet) throws SQLException {
        return new Student(resultSet.getLong(ID_COL_NAME),
                resultSet.getLong(ACCOUNT_ID_COL_NAME),
                resultSet.getLong(FACULTY_ID_COL_NAME),
                resultSet.getLong(SPECIALTY_ID_COL_NAME),
                resultSet.getDate(ENROLLMENT_DATE_COL_NAME),
                StudentStatus.valueOf(resultSet.getString(STATUS_COL_NAME).toUpperCase()));
    }
}
