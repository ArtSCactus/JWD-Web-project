package com.epam.model.rowmappers;

import com.epam.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    private static final String LOGIN_COLUMN_NAME = "login";
    private static final String PASSWORD_COLUMN_NAME = "password";
    private static final String MAILBOX_COLUMN_NAME = "mailbox";
    private static final String ID_COLUMN_NAME = "id";


    @Override
    public User map(ResultSet resultSet) throws SQLException {
        return new User.Builder()
                .withId(resultSet.getLong(ID_COLUMN_NAME))
                .withLogin(resultSet.getString(LOGIN_COLUMN_NAME))
                .withPassword(resultSet.getString(PASSWORD_COLUMN_NAME))
                .withMailbox(resultSet.getString(MAILBOX_COLUMN_NAME))
                .build();
    }
}
