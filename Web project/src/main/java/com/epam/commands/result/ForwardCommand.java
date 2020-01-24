package com.epam.commands.result;

import com.epam.commands.main.Command;
import com.epam.commands.main.CommandResult;

import javax.servlet.http.HttpServletRequest;

public class ForwardCommand implements Command {
    private static final String SIGN_IN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main.jsp";
    private static final String CONTROL_PANEL_PAGE_PATH="/WEB-INF/jsp/control panel.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(definePage(request.getParameter("page")));
    }

    private String definePage(String parameter) {
        switch (parameter) {
            case "authorization":
                return SIGN_IN_PAGE_PATH;
            case "main":
                return MAIN_PAGE_PATH;
            case "control-panel":
                return CONTROL_PANEL_PAGE_PATH;
            default:
                return null;
        }
    }
}
