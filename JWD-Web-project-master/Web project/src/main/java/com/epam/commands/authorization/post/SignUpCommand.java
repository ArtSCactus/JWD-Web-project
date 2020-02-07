package com.epam.commands.authorization.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.Account;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final String REDIRECT_URL = "/controller?command=show_main_page";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AccountService service = new AccountService();
        //TODO: parameters validation here
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
        return new CommandResult( REDIRECT_URL, CommandType.POST);
    }
}
