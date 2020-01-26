package com.epam.commands.controlpanel.view;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.entity.Application;
import com.epam.model.entity.controlpanel.PageContent;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowApplicationsAdminMenu implements Command {
    private static final String CONTROL_PANEL_PAGE = "/WEB-INF/jsp/control panel/applications admin panel.jsp";
    private static final String REDIRECT_URL = "/controller?command=show_applications_panel";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        PageContent container = new PageContent();
        ApplicationService service = new ApplicationService();
        List<Application> applicationList = service.getApplicationsList();
        container.setContent(applicationList);
        request.setAttribute("content", container);
        return new CommandResult(CONTROL_PANEL_PAGE, REDIRECT_URL, CommandType.GET);
    }
}
