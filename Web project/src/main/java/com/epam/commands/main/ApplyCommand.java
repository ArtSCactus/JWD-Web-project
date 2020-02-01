package com.epam.commands.main;

import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplyCommand implements Command {
    private static final String LOGIN_PAGE = "/WEB-INF/jsp/main/login.jsp";
    private static final String MAIN_PAGE = "/WEB-INF/jsp/main/main.jsp";
    private static final String IS_USER_DEFINED_ATTR="isDefined";
    private static final String FACULTY_PARAM = "faculty";
    private static final String SPECIALTY_PARAM = "specialty";
    private static final String ACCOUNT_ID_ATTR="accountId";
    private static final String REDIRECT_MAIN_URL = "/controller?command=forward&page=main";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (Boolean.parseBoolean((String) session.getAttribute(IS_USER_DEFINED_ATTR))) {
            ApplicationService service = new ApplicationService();
            service.apply(Long.parseLong(request.getParameter(FACULTY_PARAM)),
                    Long.parseLong(request.getParameter(SPECIALTY_PARAM)),
                    (Long) session.getAttribute(ACCOUNT_ID_ATTR));
            return new CommandResult(REDIRECT_MAIN_URL, CommandType.POST);
        } else {
            return new CommandResult(LOGIN_PAGE, CommandType.GET);
        }
    }
}
