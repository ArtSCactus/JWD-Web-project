package com.epam.model;

import exceptions.DatabaseConnectionException;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Database {
    private static Database obj;
    private Connection connection;

    private Database() {

    }

    public static Database getInstance() {
        if (obj == null) {
            return new Database();
        } else {
            return obj;
        }
    }

    public boolean checkDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public void connect(String url) throws DatabaseConnectionException {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e);
        }
    }

    public void connect(String url, String user, String password) throws DatabaseConnectionException {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e);
        }
    }

    public void disconnect() throws SQLException {
        if (!connection.isClosed()){
            connection.close();
        }
    }

    public ResultSet executeRequest(String request) throws SQLException {
        Statement statement = connection.prepareStatement(request);
        return  statement.executeQuery(request);
    }

}
