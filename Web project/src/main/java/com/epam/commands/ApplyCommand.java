package com.epam.commands;

import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplyCommand implements Command {
    private static final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
    private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
    private static final String IS_USER_DEFINED_ATTR="isDefined";
    private static final String FACULTY_PARAM = "faculty";
    private static final String SPECIALTY_PARAM = "specialty";
    private static final String ACCOUNT_ID_ATTR="accountId";

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (Boolean.parseBoolean((String) session.getAttribute(IS_USER_DEFINED_ATTR))) {
            ApplicationService service = new ApplicationService();
            service.apply(Long.parseLong(request.getParameter(FACULTY_PARAM)),
                    Long.parseLong(request.getParameter(SPECIALTY_PARAM)),
                    (Long) session.getAttribute(ACCOUNT_ID_ATTR));
            return MAIN_PAGE;
        } else {
            return LOGIN_PAGE;
        }
    }
}
