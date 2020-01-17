package com.epam.model.rowmappers;

import com.epam.model.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<Account> {
    private static final String LOGIN_COLUMN_NAME = "login";
    private static final String PASSWORD_COLUMN_NAME = "password";
    private static final String MAILBOX_COLUMN_NAME = "mailbox";
    private static final String ID_COLUMN_NAME = "id";
    private static final String ADMIN_STATUS_COL_NAME="adminStatus";


    @Override
    public Account map(ResultSet resultSet) throws SQLException {
        return new Account.Builder()
                .withId(resultSet.getLong(ID_COLUMN_NAME))
                .withLogin(resultSet.getString(LOGIN_COLUMN_NAME))
                .withPassword(resultSet.getString(PASSWORD_COLUMN_NAME))
                .withMailbox(resultSet.getString(MAILBOX_COLUMN_NAME))
                .withAdminStatus(resultSet.getBoolean(ADMIN_STATUS_COL_NAME))
                .build();
    }
}
