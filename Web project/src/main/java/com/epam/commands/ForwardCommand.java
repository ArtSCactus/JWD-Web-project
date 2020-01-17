package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ForwardCommand implements Command {
    private static final String SIGN_IN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return definePage(request.getParameter("page"), request);
    }

    private String definePage(String parameter, HttpServletRequest request) {
        switch (parameter) {
            case "authorization":
                return SIGN_IN_PAGE_PATH;
            case "main":
                return MAIN_PAGE_PATH;
            default:
                return null;
        }
    }
}
