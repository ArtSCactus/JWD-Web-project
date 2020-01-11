package com.epam.commands;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = "/index.jsp";
        request.getSession().invalidate();
        return page;
    }
}
