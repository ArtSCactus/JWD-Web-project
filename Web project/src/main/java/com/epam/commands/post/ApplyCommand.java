package com.epam.commands.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ApplyCommand implements Command {
    private static final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
    private static final String MAIN_PAGE = "/WEB-INF/jsp/main/main.jsp";
    private static final String FACULTY_PARAM = "faculty";
    private static final String SPECIALTY_PARAM = "specialty";
    private static final String ACCOUNT_ID_ATTR = "accountId";
    private static final String ADMISSION_ID = "admissionId";
    private static final String REDIRECT_MAIN_URL = "/controller?command=show_main_page";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long accountId = (Long) session.getAttribute(ACCOUNT_ID_ATTR);
        if (accountId != null) {
            ApplicationService service = new ApplicationService();
            service.apply(Long.parseLong(request.getParameter(FACULTY_PARAM)),
                    Long.parseLong(request.getParameter(SPECIALTY_PARAM)),
                    (Long) session.getAttribute(ACCOUNT_ID_ATTR),
                    Long.parseLong(request.getParameter("admissionId")));
            return new CommandResult(REDIRECT_MAIN_URL, CommandType.POST);
        } else {
            return new CommandResult(LOGIN_PAGE, CommandType.GET);
        }
    }
}
