package com.epam.commands;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    private static final String PAGE_PATH = "/WEB-INF/jsp/index.jsp";
//TODO: put isLoggedIn to session;
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute("isUserDefined", false);
        return PAGE_PATH;
    }
}
