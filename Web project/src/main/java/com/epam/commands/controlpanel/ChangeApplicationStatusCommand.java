package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.entity.Application;
import com.epam.model.entity.ApplicationStatus;
import com.epam.model.entity.controlpanel.PageContent;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class ChangeApplicationStatusCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH = "/WEB-INF/jsp/control panel/applications admin panel.jsp";
    private static final String REDIRECT_URL = "/controller?command=show_applications_panel";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long applicationId = Long.parseLong(request.getParameter("applicationId"));
        ApplicationStatus newStatus = ApplicationStatus.valueOf(request.getParameter("newStatus").toUpperCase());
        ApplicationService service = new ApplicationService();
        Optional<Application> foundApplication = service.getApplicationById(applicationId);
        if (foundApplication.isPresent()) {
            Application application = foundApplication.get();
            application.setStatus(newStatus);
            service.update(application);
            PageContent container = new PageContent();
            List<Application> applicationList = service.getApplicationsList();
            container.setContent(applicationList);
            request.setAttribute("content", container);
            return new CommandResult(CONTROL_PANEL_PAGE_PATH, REDIRECT_URL, CommandType.POST);
        } else {
            throw new IllegalArgumentException("Requesting application does not exist: id=" + applicationId);
        }
    }
}
