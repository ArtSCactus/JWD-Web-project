package com.epam.commands;

import com.epam.common.LoginLogic;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN="login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass= request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page ="/WEB-INF/main.jsp";
        }else {
            request.setAttribute("errorLoginPassMessage", "message.login.error");
            page = "/WEB-INF/error.jsp";
        }
        return page;
    }

}
