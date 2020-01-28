package com.epam.model.rowmappers;

import com.epam.dto.entity.Account;
import com.epam.dto.university.Faculty;
import com.epam.dto.university.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    static RowMapper create(String table) {
        switch (table) {
            case Account.TABLE_NAME:
                return new AccountRowMapper();
            case Faculty.TABLE_NAME:
                return new FacultyRowMapper();
            case Specialty.TABLE_NAME:
                return new SpecialtyRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table name: " + table);

        }
    }
}
