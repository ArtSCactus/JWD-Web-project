package com.epam.commands;

import com.epam.common.LoginLogic;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN="login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass= request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page ="/WEB-INF/jsp/main.jsp";
        }else {
            request.setAttribute("errorLoginPassMessage", "Wrong login or password. Try again");
            page = "/WEB-INF/jsp/login.jsp";
        }
        return page;
    }

}
