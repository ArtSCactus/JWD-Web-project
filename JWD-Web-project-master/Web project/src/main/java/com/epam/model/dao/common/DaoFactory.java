package com.epam.model.dao.common;

import com.epam.connection.ConnectionPool;
import com.epam.model.dao.helper.DaoManager;

public class DaoFactory {
    public static DaoManager createDaoManager(){
        return new DaoManager(ConnectionPool.getInstance());
    }
}
