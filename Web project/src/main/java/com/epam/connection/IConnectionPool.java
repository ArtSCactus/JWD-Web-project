package com.epam.connection;

import java.sql.Connection;

public interface IConnectionPool {
    Connection getConnection();
}
