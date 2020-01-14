package com.epam.model.rowmappers;

import com.epam.model.entity.Faculty;
import com.epam.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    static RowMapper create(String table) {
        switch (table) {
            case User.TABLE_NAME:
                return new UserRowMapper();
            case Faculty.TABLE_NAME:
                return new FacultyRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table name: " + table);

        }
    }
}
