package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.PageContent;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class ChangeBlockStatusCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH="/WEB-INF/jsp/applications admin panel.jsp";
    private static final String REDIRECT_URL= "/controller?command=show_accounts_panel";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long accountId = Long.valueOf(request.getParameter("accountId"));
        boolean blockStatus = Boolean.parseBoolean(request.getParameter("blockStatus"));
        AccountService service = new AccountService();
        service.changeBlockStatusAccount(accountId, blockStatus);
        PageContent content = new PageContent();
        content.setContent(service.getAccountsList());
        request.setAttribute("content", content);
        return new CommandResult(REDIRECT_URL, CommandType.POST);
    }

}
