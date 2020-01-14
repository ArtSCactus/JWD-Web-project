package com.epam.commands;

import com.epam.model.entity.User;
import com.epam.service.AccountService;
import exceptions.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
//TODO: place pages to properties file
public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main.jsp";
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";

    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (checkLogin(login, pass)) {
            request.setAttribute("user", login);
            //TODO: put isLoggedIn to session
            request.setAttribute("isUserDefined", true);
            return MAIN_PAGE_PATH;
        } else {
            request.setAttribute("errorLoginPassMessage", "Wrong login or password. Try again");
            return LOGIN_PAGE_PATH;
        }
    }

    private boolean checkLogin(String enterLogin, String enterPass) {
        AccountService service = new AccountService();
        try {
            Optional<User> foundUser = service.login(enterLogin, enterPass);
            return foundUser.isPresent();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return false;
    }

}
