package com.epam.model.dao.common;

import com.epam.model.builders.Manufacturer;
import exceptions.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);
    protected Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected Optional<T> executeForSingleResult(String sql, Manufacturer<T> manufacturer, Object... params) throws DaoException {
        try (PreparedStatement statement = prepareStatement(sql, params)) {
            ResultSet resultSet = statement.executeQuery();
            return manufacturer.assembleSingle(resultSet);
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            LOGGER.error("An error occurred while single result dao request executing");
            throw new DaoException("An error occurred while single result dao request executing", e);
        }
    }

    protected List<T> executeQuery(String sql, Manufacturer<T> manufacturer, Object... params) throws DaoException {
        try (PreparedStatement statement = prepareStatement(sql, params)) {
            ResultSet resultSet = statement.executeQuery();
            return manufacturer.assembleMultiple(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("An error occurred while multiple result dao request executing");
            throw new DaoException("An error occurred while multiple result dao request executing", e);
        }
    }


    private PreparedStatement prepareStatement(String sql, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int index = 1; index <= params.length; index++) {
            try {
                statement.setObject(index, params[index-1]);
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error("An error occurred while statement preparing", e);
                throw new SQLException(e);
            }
        }
        return statement;
    }

}
