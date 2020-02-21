package com.epam.model.dao.common;

import com.epam.model.rowmappers.RowMapper;
import exception.dao.DaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Statement executor.
 *
 * @param <T> - type of return value
 * @author ArtSCactus
 * @version 0.1.2
 */
public abstract class AbstractDao<T> implements Dao<T> {
    //TODO: requests path to config
    private static final String GET_REQUESTS_PATH = "sql/get";
    private static final String PUT_REQUESTS_PATH = "sql/put";
    private static final String REMOVE_REQUESTS_PATH = "sql/remove";
    protected Connection connection;
    protected ResourceBundle getRequests;
    protected ResourceBundle putRequests;

    protected AbstractDao(Connection connection) {
        initProperties();
        this.connection = connection;
    }

    private void initProperties(){
        getRequests = PropertyResourceBundle.getBundle("sql/get");
        putRequests = PropertyResourceBundle.getBundle("sql/put");
    }

    /**
     * Executes query and returns list of objects, provided by rowMapper.
     *
     * @param sql       request template
     * @param rowMapper {@code RowMapper<T>} interface implementation
     * @param params    params, that will be set to statement.
     * @return {@code List<T>} of objects, provided by RowMapper.
     * @throws DaoException if was caught an SQLException;
     */
    protected List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object... params) throws DaoException {
        try (PreparedStatement statement = prepareStatement(sql, params)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                List<T> objects = new ArrayList<>();
                while (resultSet.next()) {
                    objects.add(rowMapper.map(resultSet));
                }
                return objects;
            }
        } catch (SQLException e) {
            throw new DaoException("An error occurred while request executing", e);
        }
    }

    /**
     * Executes the update statement.
     * Executes update by calling {@code executeUpdate()} method of PreparedStatement interface
     *
     * @param sql    request template
     * @param params params, that will be set to statement.
     * @return amount of affected rows.
     * @throws DaoException if was caught an SQLException;
     * @see PreparedStatement
     */
    protected int executeUpdate(String sql, Object... params) {
        try (PreparedStatement statement = prepareStatement(sql, params)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("An error occurred while request executing", e);
        }
    }

    protected String getSelectRequest(String propertyName){
        return getRequests.getString(propertyName);
    }

    protected String getPutRequest(String propertyName){
        return putRequests.getString(propertyName);
    }

    private PreparedStatement prepareStatement(String sql, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int index = 1; index <= params.length; index++) {
            try {
                statement.setObject(index, params[index - 1]);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return statement;
    }

}
