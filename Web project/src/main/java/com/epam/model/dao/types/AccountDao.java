package com.epam.model.dao.types;

import com.epam.model.entity.Account;
import com.epam.model.rowmappers.UserRowMapper;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AccountDao extends AbstractDao<Account> implements Dao<Account> {
    private static final String GET_BY_LOGIN_AND_PASSWORD_REQ =
            "select * from accounts where login = ? and password = sha1(?)";

    public AccountDao(Connection connection) {
        super(connection);
    }

    public Optional<Account> getByLoginAndPassword(String login, String password) throws DaoException {
        List<Account> list = super.executeQuery(GET_BY_LOGIN_AND_PASSWORD_REQ,
                new UserRowMapper(),
                login,
                password);
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }


    @Override
    public Optional<Account> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void save(Account item) {
    }

    @Override
    public void removeById(Long id) {

    }
}
