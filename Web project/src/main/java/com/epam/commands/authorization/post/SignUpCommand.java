package com.epam.commands.authorization.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.Account;
import com.epam.service.AccountService;
import com.epam.validator.AccountDataValidator;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final String MAIN_REDIRECT_URL = "/controller?command=show_main_page";
    private static final String REGISTRATION_REDIRECT_URL = "/controller?command=forward&page=registration";
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/registration page.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        AccountService service = new AccountService();
        AccountDataValidator validator = new AccountDataValidator();
        if (validator.validateAll(request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("mailbox"),
                request.getParameter("total points"),
        request.getParameter("first name"),
        request.getParameter("second name"),
        request.getParameter("third name"))) {
            Account account = new Account.Builder()
                    .withId(null)
                    .withLogin(request.getParameter("login"))
                    .withPassword(request.getParameter("password"))
                    .withMailbox(request.getParameter("mailbox"))
                    .withName(request.getParameter("first name"))
                    .withSecondName(request.getParameter("second name"))
                    .withThirdName(request.getParameter("third name"))
                    .withTotalPoints(Integer.parseInt(request.getParameter("total points")))
                    .withAdminStatus(false)
                    .withBlockStatus(false)
                    .build();
            service.signUp(account);
            return new CommandResult(MAIN_REDIRECT_URL, CommandType.POST);
        } else {
            request.setAttribute("error_message", "One of the fields is incorrect. Please, check and try again");
            return new CommandResult(REGISTRATION_REDIRECT_URL, CommandType.POST);
        }
    }
}
