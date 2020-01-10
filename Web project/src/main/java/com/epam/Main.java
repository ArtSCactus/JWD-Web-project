package com.epam;

import com.epam.connection.ConnectionPool;
import com.epam.connection.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Only for temporal use, just to test some small features
public class Main {
    public static void main(String[] args){
      //  Database database = Database.getInstance();

       /* try {
            database.checkDriver();
            System.out.println("Driver successfully loaded");
            database.connect("jdbc:mysql://localhost/basic?useUnicode=true&useJDBCCompliantTimezoneShift=" +
                            "true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "1f45d867911ArT");
           ResultSet resultSet=  database.executeRequest("select * from dinosaurs");
           resultSet.next();
            System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2));
            resultSet.close();
        } catch (DatabaseConnectionException | SQLException e) {
            e.printStackTrace();
        }*/
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
