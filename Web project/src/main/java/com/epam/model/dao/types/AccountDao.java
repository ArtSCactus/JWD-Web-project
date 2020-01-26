package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.Account;
import com.epam.model.rowmappers.AccountRowMapper;
import exceptions.dao.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AccountDao extends AbstractDao<Account> implements Dao<Account> {
    private static final String INSERT_ODKU_REQ="insert into accounts (id, login, password, mailbox, adminStatus, " +
            "blockStatus) VALUES (?, ?, sha1(?),?, ?, ?) on duplicate key update id=values(id), login=values(login), " +
            "password=values(password), mailbox=values(mailbox), adminStatus=values(adminStatus), " +
            "blockStatus=values(blockStatus);";
    private static final String GET_BY_LOGIN_AND_PASSWORD_REQ =
            "select * from accounts where login = ? and password = sha1(?)";
    private static final String GET_BY_ID_REQ ="select * from accounts where id = ?";
    private static final String GET_ALL_REQ = "select * from accounts";

    public AccountDao(Connection connection) {
        super(connection);
    }

    public Optional<Account> getByLoginAndPassword(String login, String password) throws DaoException {
        List<Account> list = super.executeQuery(GET_BY_LOGIN_AND_PASSWORD_REQ,
                new AccountRowMapper(),
                login,
                password);
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }


    @Override
    public Optional<Account> getById(Long id) {
           List<Account> accountsList= super.executeQuery(GET_BY_ID_REQ, new AccountRowMapper(), id);
           if (accountsList.isEmpty()){
               return Optional.empty();
           } else {
               return Optional.of(accountsList.get(0));
           }
    }

    @Override
    public List<Account> getAll() {
        return super.executeQuery(GET_ALL_REQ, new AccountRowMapper());
    }

    @Override
    public void save(Account item) {
        super.executeUpdate(INSERT_ODKU_REQ,
                item.getId(),
                item.getLogin(),
                item.getPassword(),
                item.getMailbox(),
                item.isAdmin(),
                item.isBlocked());
    }

    @Override
    public void removeById(Long id) {

    }

    public void create(Account account){

    }
}
