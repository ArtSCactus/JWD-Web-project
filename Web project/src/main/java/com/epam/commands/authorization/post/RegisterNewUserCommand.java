package com.epam.commands.authorization.post;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.dto.entity.Account;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class RegisterNewUserCommand implements Command {
    private static final String REDIRECT_URL = "controller?command=forward&page=authorization";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AccountService service = new AccountService();
        Account account = new Account.Builder()
                .withId(null)
                .withLogin(request.getParameter("login"))
                .withPassword(request.getParameter("password"))
                .withMailbox(request.getParameter("mailbox"))
                .build();
        service.registerNewUser(account);
        return new CommandResult(null, REDIRECT_URL, CommandType.POST);
    }
}
