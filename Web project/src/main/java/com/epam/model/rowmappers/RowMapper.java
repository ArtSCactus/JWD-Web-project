package com.epam.model.rowmappers;

import com.epam.model.entity.Account;
import com.epam.model.entity.Faculty;
import com.epam.model.entity.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    static RowMapper create(String table) {
        switch (table) {
            case Account.TABLE_NAME:
                return new UserRowMapper();
            case Faculty.TABLE_NAME:
                return new FacultyRowMapper();
            case Specialty.TABLE_NAME:
                return new SpecialtyRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table name: " + table);

        }
    }
}
