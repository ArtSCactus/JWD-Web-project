package com.epam.model.dao.types;

import com.epam.model.rowmappers.UserRowMapper;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.User;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AccountDao extends AbstractDao<User> implements Dao<User> {
    private static final String GET_BY_LOGIN_AND_PASSWORD_REQ =
            "select * from accounts where login = ? and password = sha1(?)";

    public AccountDao(Connection connection) {
        super(connection);
    }

    public Optional<User> getByLoginAndPassword(String login, String password) throws DaoException {
        List<User> list = super.executeQuery(GET_BY_LOGIN_AND_PASSWORD_REQ,
                new UserRowMapper(),
                login,
                password);
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));

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
