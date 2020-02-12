package com.epam.model.rowmappers.table;

import com.epam.model.dto.entity.Student;
import com.epam.model.dto.entity.StudentStatus;
import com.epam.model.rowmappers.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class StudentTableRowMapper implements RowMapper<Student> {
    private static final String ID_COL = "id";
    private static final String ACCOUNT_ID_COL = "accountId";
    private static final String FACULTY_ID_COL = "facultyId";
    private static final String SPECIALTY_ID_COL = "specialtyId";
    private static final String ENROLLMENT_DATE_COL = "enrollmentDate";
    private static final String STATUS_COL = "status";
    private static final String NAME_COL = "name";
    private static final String SURNAME_COL = "surname";
    private static final String PATRONYMIC_COL = "patronymic";

    @Override
    public Student map(ResultSet resultSet) throws SQLException {
        return new Student(resultSet.getLong(ID_COL),
                resultSet.getLong(ACCOUNT_ID_COL),
                resultSet.getLong(FACULTY_ID_COL),
                resultSet.getLong(SPECIALTY_ID_COL),
                resultSet.getDate(ENROLLMENT_DATE_COL),
                StudentStatus.valueOf(resultSet.getString(STATUS_COL).toUpperCase()),
                resultSet.getString(NAME_COL),
                resultSet.getString(SURNAME_COL),
                resultSet.getString(PATRONYMIC_COL));
    }
}
