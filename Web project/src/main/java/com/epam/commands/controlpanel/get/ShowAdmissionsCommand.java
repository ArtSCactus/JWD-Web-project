package com.epam.commands.controlpanel.get;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.dto.entity.Admission;
import com.epam.dto.PageContent;
import com.epam.service.AdmissionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAdmissionsCommand implements Command {
    private static final String ADMISSIONS_PAGE_PATH = "/WEB-INF/jsp/control panel/admission table.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        AdmissionService service = new AdmissionService();
        List<Admission> admissionList = service.getAdmissionList();
        PageContent content = new PageContent();
        content.setContent(admissionList);
        request.setAttribute("content", content);
        return new CommandResult(ADMISSIONS_PAGE_PATH, null, CommandType.GET);
    }
}
