package com.epam.model.rowmappers;

import com.epam.model.dto.university.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialtyRowMapper implements RowMapper<Specialty> {
    private static final String ID_COLUMN="id";
    private static final String NAME_EN_COLUMN = "name_en";
    private static final String NAME_RU_COLUMN ="name_ru";
    private static final String DESCRIPTION_EN_COLUMN = "description_en";
    private static final String DESCRIPTION_RU_COLUMN = "description_ru";
    private static final String FACULTY_ID_COLUMN = "facultyId";
    private static final String ADMISSION_ID_COLUMN = "admissionId";
    @Override
    public Specialty map(ResultSet resultSet) throws SQLException {
        return new Specialty(resultSet.getLong(ID_COLUMN),
                resultSet.getLong(FACULTY_ID_COLUMN),
                resultSet.getString(NAME_EN_COLUMN),
                resultSet.getString(DESCRIPTION_EN_COLUMN),
                resultSet.getLong(ADMISSION_ID_COLUMN));
    }
}
