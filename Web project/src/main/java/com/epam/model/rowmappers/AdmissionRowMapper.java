package com.epam.model.rowmappers;

import com.epam.model.entity.Admission;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmissionRowMapper implements RowMapper<Admission> {
    private static final String ID_COL_NAME = "id";
    private static final String START_COL_NAME = "start";
    private static final String END_COL_NAME = "end";
    private static final String DESCRIPTION_COL_NAME = "description";
    private static final String STATUS_COL_NAME = "status";

    @Override
    public Admission map(ResultSet resultSet) throws SQLException {
        return new Admission(resultSet.getLong(ID_COL_NAME),
                resultSet.getDate(START_COL_NAME),
                resultSet.getDate(END_COL_NAME),
                resultSet.getString(DESCRIPTION_COL_NAME),
                resultSet.getBoolean(STATUS_COL_NAME));
    }
}
