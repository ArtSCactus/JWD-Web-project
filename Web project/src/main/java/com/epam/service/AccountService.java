package com.epam.service;

import com.epam.model.dao.AccountDao;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.entity.User;
import exceptions.dao.DaoException;
import exceptions.service.AccountServiceException;

import java.util.Optional;

public class AccountService {

    public AccountService() {
    }

    public Optional<User> login(String login, String password) throws AccountServiceException {
        try(DaoManager dao = DaoManager.create()){
           AccountDao accountDao = dao.getAccountDao();
           return accountDao.getByLoginAndPassword(login, password);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new AccountServiceException(e);
        }
    }
}
