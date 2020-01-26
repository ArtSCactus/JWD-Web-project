package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.types.AccountDao;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.entity.Account;
import exceptions.dao.DaoException;
import exceptions.service.ServiceException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AccountService {

    public AccountService() {
    }

    public Optional<Account> login(String login, String password) throws ServiceException {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.getByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isAccountBlocked(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            Optional<Account> accountOptional =accountDao.getById(id);
            if (accountOptional.isPresent()){
                Account account = accountOptional.get();
                return account.isBlocked();
            } else {
                throw new ServiceException("Account with given id not exists");
            }
        }
    }

    public void changeBlockStatusAccount(Long id, boolean status){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            Optional<Account> accountOptional =accountDao.getById(id);
            if (accountOptional.isPresent()){
                Account account = accountOptional.get();
                account.setBlocked(status);
                accountDao.save(account);
            } else {
                throw new ServiceException("Account with given id not exists");
            }
        }
    }

    public List<Account> getAccountsList(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.getAll();
        }
    }


}
