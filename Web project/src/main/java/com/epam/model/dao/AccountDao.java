package com.epam.model.dao;

import com.epam.model.builders.UserManufacturer;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.entity.User;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AccountDao extends AbstractDao<User> {
    //TODO: Insert SHA-1 encryption to request
    private static final String GET_BY_LOGIN_AND_PASSWORD_REQ =
            "select * from webappdatabase.accounts where login = ? and password = sha1(?)";

    public AccountDao(Connection connection) {
        super(connection);
    }

    public Optional<User> getByLoginAndPassword(String login, String password) throws DaoException {
        return super.executeForSingleResult(GET_BY_LOGIN_AND_PASSWORD_REQ,
                new UserManufacturer(),
                login,
                password);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll(String sql) {
        return null;
    }

    @Override
    public void save(User item) {

    }

    @Override
    public void update(Long id, Object... params) {

    }

    @Override
    public void removeById(Long id) {

    }
}
