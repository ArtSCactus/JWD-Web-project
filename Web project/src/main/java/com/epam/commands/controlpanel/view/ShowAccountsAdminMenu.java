package com.epam.commands.controlpanel.view;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.entity.Account;
import com.epam.model.entity.controlpanel.PageContent;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAccountsAdminMenu implements Command {
    private static final String ACCOUNTS_ADMIN_PANEL_PAGE= "/WEB-INF/jsp/control panel/accounts admin panel.jsp";
    private static final String REDIRECT_URL = "/controller?command=show_accounts_panel";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        PageContent container = new PageContent();
        AccountService service = new AccountService();
        List<Account> accountsList = service.getAccountsList();
        container.setContent(accountsList);
        request.setAttribute("content", container);
        return new CommandResult(ACCOUNTS_ADMIN_PANEL_PAGE, REDIRECT_URL, CommandType.GET);
    }
}
