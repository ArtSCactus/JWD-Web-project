package com.epam.commands;

import javax.servlet.http.HttpServletRequest;

public class ShowCommand implements Command {
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/login.jsp";

    public String execute(HttpServletRequest request) {
        return LOGIN_PAGE_PATH;
    }
}
