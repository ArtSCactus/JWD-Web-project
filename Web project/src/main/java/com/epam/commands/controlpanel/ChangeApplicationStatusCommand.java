package com.epam.commands.controlpanel;

import com.epam.commands.main.Command;
import com.epam.commands.main.CommandResult;
import com.epam.model.entity.Application;
import com.epam.model.entity.ApplicationStatus;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ChangeApplicationStatusCommand implements Command {
    private static final String CONTROL_PANEL_PAGE_PATH = "/WEB-INF/jsp/control panel.jsp";

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
            updateControlPanelData(request);
            return new CommandResult(CONTROL_PANEL_PAGE_PATH);
        } else {
            throw new IllegalArgumentException("Requesting application does not exist: id=" + applicationId);
        }
    }
    private void updateControlPanelData(HttpServletRequest request){
        new ShowControlPanelCommand().prepareDataForPage(request);
    }
}
