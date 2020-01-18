package com.epam.model.dao.helper;

import com.epam.connection.ConnectionPool;
import com.epam.model.dao.types.AccountDao;
import com.epam.model.dao.types.FacultyDao;
import com.epam.model.dao.types.SpecialtyDao;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoManager implements AutoCloseable {
    private Connection connection;

    public DaoManager(ConnectionPool connectionPool) {
        this.connection = connectionPool.getConnection();
    }

    public static DaoManager create(){
        return new DaoManager(ConnectionPool.getInstance());
    }

    public AccountDao getAccountDao(){
        return new AccountDao(connection);
    }

    public FacultyDao getFacultyDao(){
        return new FacultyDao(connection);
    }

    public SpecialtyDao getSpecialtyDao(){
        return new SpecialtyDao(connection);
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
