package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.main.CommandResult;
import com.epam.model.entity.Application;
import com.epam.model.entity.controlpanel.PageContent;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowControlPanelCommand implements Command {
    private static final String CONTROL_PANEL_PAGE = "/WEB-INF/jsp/control panel.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        prepareDataForPage(request);
        return new CommandResult(CONTROL_PANEL_PAGE);
    }

    //TODO: make adaptive to students/admissions/accounts
    public void prepareDataForPage(HttpServletRequest request) {
        PageContent container = new PageContent();
        ApplicationService service = new ApplicationService();
        List<Application> applicationList = service.getApplicationsList();
        container.setContent(applicationList);
        request.setAttribute("content", container);
    }
}
