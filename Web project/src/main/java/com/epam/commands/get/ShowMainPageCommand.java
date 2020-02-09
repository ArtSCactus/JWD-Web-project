package com.epam.commands.get;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.PageContent;
import com.epam.model.dto.entity.Application;
import com.epam.service.ApplicationService;
import com.epam.service.FacultyService;
import com.epam.service.SpecialtyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowMainPageCommand implements Command {
    private static final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main/main.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        FacultyService facultyService = new FacultyService();
        SpecialtyService specialtyService = new SpecialtyService();
        ApplicationService applicationService = new ApplicationService();
        HttpSession session = request.getSession();
        Long accountId = (Long) session.getAttribute("accountId");
        PageContent content = new PageContent();
        content.setAttribute("faculties",facultyService.getAllFaculties());
        content.setAttribute("specialties", specialtyService.getAllSpecialties());
        if (accountId!=null){
            List<Application> applicationList = applicationService.getAppliedApplications(accountId);
            content.setAttribute("existingApplications", applicationList);
        }
        request.setAttribute("content", content);
        return new CommandResult(MAIN_PAGE_PATH, CommandType.GET);
    }
}
