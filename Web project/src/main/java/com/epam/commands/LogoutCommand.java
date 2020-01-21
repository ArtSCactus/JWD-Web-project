package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String PAGE_PATH = "/WEB-INF/jsp/main.jsp";

    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setAttribute("isUserAdmin", false);
        session.setAttribute("accountId", null);
        return new CommandResult(PAGE_PATH);
    }
}
