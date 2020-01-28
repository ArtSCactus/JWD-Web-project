package com.epam.model.dao.helper;

import com.epam.connection.ConnectionPool;
import com.epam.model.dao.types.*;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoManager implements AutoCloseable {
    private Connection connection;

    public DaoManager(ConnectionPool connectionPool) {
        this.connection = connectionPool.getConnection();
    }

    /**
     * @deprecated use DaoFactory instead
     * @return DaoManager obj
     */
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

    public ApplicationDao getApplicationDao(){
        return new ApplicationDao(connection);
    }

    public StudentDao getStudentDao(){
        return new StudentDao(connection);
    }

    public AdmissionDao getAdmissionDao(){
        return new AdmissionDao(connection);
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
