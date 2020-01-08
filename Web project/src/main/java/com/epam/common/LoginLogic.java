package com.epam.common;

import com.epam.connection.ConnectionPool;
import com.epam.connection.ProxyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "root";

    public static boolean checkLogin(String enterLogin, String enterPass) {
        //return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
        //TODO: create User repository, and replace LoginLogic on normal service
        ProxyConnection connection = (ProxyConnection) ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM webappdatabase.accounts");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString(1).contains(enterLogin) & resultSet.getString(2).contains(enterPass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
