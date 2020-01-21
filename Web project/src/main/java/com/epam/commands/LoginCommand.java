package com.epam.commands;

import com.epam.model.entity.Account;
import com.epam.service.AccountService;
import exceptions.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main.jsp";
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private static final String ERROR_PAGE_PATH = "/WEB-INF/jsp/error.jsp";

    public CommandResult execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        HttpSession session = request.getSession(true);
        Optional<Account> account = findUser(login, pass);
        if (account.isPresent()) {
            Account currentAccount = account.get();
            request.setAttribute("user", login);
            session.setAttribute("isUserAdmin", currentAccount.isAdmin());
            session.setAttribute("accountId", currentAccount.getId());
            return new CommandResult(MAIN_PAGE_PATH);
        } else {
            request.setAttribute("errorLoginPassMessage", "Wrong login or password. Try again");
            return new CommandResult(LOGIN_PAGE_PATH);
        }
    }

    private Optional<Account> findUser(String enterLogin, String enterPass) {
        AccountService service = new AccountService();
        try {
            return service.login(enterLogin, enterPass);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
