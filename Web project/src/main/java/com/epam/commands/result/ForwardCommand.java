package com.epam.commands.result;

import com.epam.commands.common.Command;

import javax.servlet.http.HttpServletRequest;

//TODO: should be deleted and replace on forward/redirect
public class ForwardCommand implements Command {
    private static final String SIGN_IN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/common/common.jsp";
    private static final String REGISTRATION_PAGE_PATH = "/WEB-INF/jsp/registration page.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(definePage(request.getParameter("page")), CommandType.GET);
    }

    private String definePage(String parameter) {
        switch (parameter) {
            case "authorization":
                return SIGN_IN_PAGE_PATH;
            case "common":
                return MAIN_PAGE_PATH;
            case "registration":
                return REGISTRATION_PAGE_PATH;
            default:
                return null;
        }
    }
}
