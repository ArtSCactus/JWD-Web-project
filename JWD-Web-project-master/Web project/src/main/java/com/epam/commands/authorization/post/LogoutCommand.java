package com.epam.commands.authorization.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String PAGE_PATH = "/WEB-INF/jsp/jsp";
    private static final String REDIRECT_URL = "/controller?command=show_main_page";

    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setAttribute("isUserAdmin", false);
        session.setAttribute("accountId", null);
        return new CommandResult(REDIRECT_URL, CommandType.POST);
    }
}
