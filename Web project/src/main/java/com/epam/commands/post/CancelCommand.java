package com.epam.commands.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.Application;
import com.epam.model.dto.entity.ApplicationStatus;
import com.epam.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class CancelCommand implements Command {
    //TODO: create 404 page and redirect to it
    private static final String REDIRECT_TO_404_URL = "/WEB-INF/jsp/stacktrace page.jsp";
    private static final String REDIRECT_TO_MAIN_URL = "/controller?command=show_main_page";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long accountId = (Long) request.getSession().getAttribute("accountId");
        Long specialtyId = Long.parseLong(request.getParameter("specialty"));
        ApplicationService service = new ApplicationService();
        Optional<Application> applicationOptional = service.getByAccountIdAndSpecialtyId(accountId, specialtyId);
        if (applicationOptional.isPresent()) {
            Application application = applicationOptional.get();
            application.setStatus(ApplicationStatus.CANCELLED);
            service.update(application);
        } else {
            request.setAttribute("message", "No application found by accountId: " + accountId + " and specialty id: " + specialtyId);
            return new CommandResult(REDIRECT_TO_404_URL, CommandType.GET);
        }
        return new CommandResult(REDIRECT_TO_MAIN_URL, CommandType.POST);
    }
}
