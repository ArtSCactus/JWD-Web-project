package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.main.CommandResult;
import com.epam.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class ChangeBlockStatusCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH="/WEB-INF/jsp/control panel.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long accountId = Long.valueOf(request.getParameter("accountId"));
        boolean blockStatus = Boolean.parseBoolean(request.getParameter("blockStatus"));
        AccountService service = new AccountService();
        service.changeBlockStatusAccount(accountId, blockStatus);
        return new CommandResult(CONTROL_PANEL_PAGE_PATH);
    }

//TODO: create separated container for control panel data.
    private void updateControlPanelData(HttpServletRequest request){
    }
}
