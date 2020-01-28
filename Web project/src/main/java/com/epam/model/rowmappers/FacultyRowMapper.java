package com.epam.model.rowmappers;

import com.epam.dto.university.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyRowMapper implements RowMapper<Faculty> {
    private static final String ID_COLUMN="id";
    private static final String NAME_COLUMN = "name";
    private static final String DESCRIPTION_COLUMN = "description";
    @Override
    public Faculty map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID_COLUMN);
        String name = resultSet.getString(NAME_COLUMN);
        String description = resultSet.getString(DESCRIPTION_COLUMN);
        return new Faculty(id, name, description);
    }
}
