package com.epam;

import com.epam.connection.ConnectionPool;
import com.epam.connection.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Only for temporal use, just to test some small features
public class Main {
    public static void main(String[] args){
        ProxyConnection connection = (ProxyConnection) ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM webappdatabase.accounts");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            System.out.println( resultSet.getString(1).contains("Admin") & resultSet.getString(2).contains("root"));
            connection.terminate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
