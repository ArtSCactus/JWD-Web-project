package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.entity.Account;
import com.epam.model.rowmappers.AccountRowMapper;
import exception.dao.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccountDao extends AbstractDao<Account> implements Dao<Account> {
    //TODO: Update insert account statement and save method according to new table format;
    private ResourceBundle resourcesGet;
    private ResourceBundle resourcesPut;

    public AccountDao(Connection connection) {
        super(connection);
        resourcesGet = ResourceBundle.getBundle("sql requests/get");
        resourcesPut = ResourceBundle.getBundle("sql requests/put");
    }

    public Optional<Account> getByLoginAndPassword(String login, String password) throws DaoException {
        List<Account> list = super.executeQuery(resourcesGet.getString("get_account_by_login_and_password"),
                new AccountRowMapper(),
                login,
                password);
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }


    @Override
    public Optional<Account> getById(Long id) {
           List<Account> accountsList= super.executeQuery(resourcesGet.getString("get_account_by_id"), new AccountRowMapper(), id);
           if (accountsList.isEmpty()){
               return Optional.empty();
           } else {
               return Optional.of(accountsList.get(0));
           }
    }

    @Override
    public List<Account> getAll() {
        return super.executeQuery(resourcesGet.getString("get_all_accounts"), new AccountRowMapper());
    }

    @Override
    public int save(Account item) {
      return super.executeUpdate(resourcesPut.getString("insert_odku_into_accounts"),
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
}
