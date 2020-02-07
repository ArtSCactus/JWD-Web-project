package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.AccountDao;
import com.epam.model.dto.entity.Account;
import exception.dao.DaoException;
import exception.service.ServiceException;

import java.util.List;
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

    public Optional<Account> getAccountById(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.getById(id);
        }
    }

    public int signUp(Account account){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.save(account);
        }
    }

    public Optional<Account> getByLogin(String login){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            AccountDao accountDao = dao.getAccountDao();
            return accountDao.getAccountByLogin(login);
        }
    }


}
