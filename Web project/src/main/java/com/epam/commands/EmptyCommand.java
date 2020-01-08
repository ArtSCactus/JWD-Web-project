package com.epam.commands;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/login.jsp";
        return page;
    }
}
