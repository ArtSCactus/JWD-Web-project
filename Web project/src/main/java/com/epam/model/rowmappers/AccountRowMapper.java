package com.epam.model.rowmappers;

import com.epam.dto.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    private static final String LOGIN_COLUMN_NAME = "login";
    private static final String PASSWORD_COLUMN_NAME = "password";
    private static final String MAILBOX_COLUMN_NAME = "mailbox";
    private static final String ID_COLUMN_NAME = "id";
    private static final String ADMIN_STATUS_COL_NAME="adminStatus";
    private static final String BLOCK_STATUS_COL_NAME="blockStatus";
    private static final String NAME_COL = "name";
    private static final String SURNAME_COL = "surname";
    private static final String PATRONYMIC_COL = "patronymic";
    private static final String TOTAL_POINTS_COL = "totalPoints";
    private static final String STUDENT_ID_COL = "studentId";


    @Override
    public Account map(ResultSet resultSet) throws SQLException {
        return new Account.Builder()
                .withId(resultSet.getLong(ID_COLUMN_NAME))
                .withLogin(resultSet.getString(LOGIN_COLUMN_NAME))
                .withPassword(resultSet.getString(PASSWORD_COLUMN_NAME))
                .withMailbox(resultSet.getString(MAILBOX_COLUMN_NAME))
                .withAdminStatus(resultSet.getBoolean(ADMIN_STATUS_COL_NAME))
                .withBlockStatus(resultSet.getBoolean(BLOCK_STATUS_COL_NAME))
                .withName(resultSet.getString(NAME_COL))
                .withSecondName(resultSet.getString(SURNAME_COL))
                .withThirdName(resultSet.getString(PATRONYMIC_COL))
                .withTotalPoints(resultSet.getInt(TOTAL_POINTS_COL))
                .build();
    }
}
