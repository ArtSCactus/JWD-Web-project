package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String PAGE_PATH = "/WEB-INF/jsp/main.jsp";

    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setAttribute("isUserDefined", false);
        session.setAttribute("isUserAdmin", false);
        return PAGE_PATH;
    }
}
