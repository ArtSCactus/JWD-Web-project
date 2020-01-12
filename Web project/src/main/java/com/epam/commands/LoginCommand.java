package com.epam.commands;

import com.epam.model.entity.User;
import com.epam.service.AccountService;
import exceptions.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN="login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass= request.getParameter(PARAM_NAME_PASSWORD);
        if (checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page ="/WEB-INF/jsp/main.jsp";
        }else {
            request.setAttribute("errorLoginPassMessage", "Wrong login or password. Try again");
            page = "/WEB-INF/jsp/login.jsp";
        }
        return page;
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
