package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.types.AccountDao;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.entity.User;
import exceptions.dao.DaoException;
import exceptions.service.ServiceException;

import java.util.Optional;

public class AccountService {

    public AccountService() {
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.getByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
