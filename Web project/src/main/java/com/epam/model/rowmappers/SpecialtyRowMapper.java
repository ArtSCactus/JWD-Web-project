package com.epam.model.rowmappers;

import com.epam.dto.university.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialtyRowMapper implements RowMapper<Specialty> {
    private static final String ID_COLUMN="id";
    private static final String NAME_COLUMN = "name";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String FACULTY_ID_COLUMN = "facultyId";
    @Override
    public Specialty map(ResultSet resultSet) throws SQLException {
        return new Specialty(resultSet.getLong(ID_COLUMN),
                resultSet.getLong(FACULTY_ID_COLUMN),
                resultSet.getString(NAME_COLUMN),
                resultSet.getString(DESCRIPTION_COLUMN));
    }
}
