package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.main.CommandResult;
import com.epam.model.entity.controlpanel.PageContent;
import com.epam.model.entity.controlpanel.PageContentType;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class ChangeBlockStatusCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH="/WEB-INF/jsp/control panel.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        //TODO: create enum for account block status.
        Long accountId = Long.valueOf(request.getParameter("accountId"));
        boolean blockStatus = Boolean.parseBoolean(request.getParameter("blockStatus"));
        AccountService service = new AccountService();
        service.changeBlockStatusAccount(accountId, blockStatus);
        PageContent content = new PageContent();
        content.setType(PageContentType.ACCOUNTS);
        content.setContent(service.getAccountsList());
        request.setAttribute("content", content);
        return new CommandResult(CONTROL_PANEL_PAGE_PATH);
    }

}
