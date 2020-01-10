package com.epam.model.builders;

import com.epam.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManufacturer implements Manufacturer<User> {
    private static final Logger LOGGER = LogManager.getLogger(UserManufacturer.class);
    private static final String LOGIN_COLUMN_NAME = "login";
    private static final String PASSWORD_COLUMN_NAME = "password";
    private static final String MAILBOX_COLUMN_NAME = "mailbox";

    @Override
    public Optional<User> assembleSingle(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return Optional.of(new User.Builder().withLogin(resultSet.getString(LOGIN_COLUMN_NAME))
                        .withPassword(resultSet.getString(PASSWORD_COLUMN_NAME))
                        .withMailbox(resultSet.getString(MAILBOX_COLUMN_NAME))
                        .build());
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            //TODO: rethrow in ManufacturerException
            e.printStackTrace();
            LOGGER.error("SQLException occurred while single user assembling. Cause: "+e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<User> assembleMultiple(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        try {
            while (resultSet.next()) {
                if (assembleSingle(resultSet).isPresent()) {
                    users.add(assembleSingle(resultSet).get());
                }
            }
        }catch (SQLException e){
            //TODO: rethrow in ManufacturerException
            e.printStackTrace();
            LOGGER.error("SQLException occurred while multiple users assembling. Cause: "+e.getMessage());
        }
        return users;
    }
}
