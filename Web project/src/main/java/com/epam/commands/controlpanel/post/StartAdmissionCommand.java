package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.service.AdmissionService;
import com.epam.service.UniversityService;
import com.epam.validator.AdmissionValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class StartAdmissionCommand implements Command {
    private static final String REDIRECT_URL = "/controller?command=show_admissions_panel";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        try {
            Map<String, Object> parameters = getParameters(request);
            UniversityService universityService = new UniversityService();
            AdmissionService admissionService = new AdmissionService();
            Long facultyId = universityService.getFacultyIdByName((String) parameters.get("faculty"));
            Long specialtyId = universityService.getSpecialtyIdByName((String) parameters.get("specialty"));
            admissionService.startAdmission(facultyId, specialtyId,
                    (Date) parameters.get("end"), ((Long) parameters.get("limit")).intValue());
            return new CommandResult(REDIRECT_URL, CommandType.POST);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "On of the fields ais incorrect." +
                    " Please, validate the fields and try again");
            return new CommandResult(REDIRECT_URL, CommandType.GET);
        }
    }

    private Map<String, Object> getParameters(HttpServletRequest request) {
        AdmissionValidator validator = new AdmissionValidator();
        if (!validator.isDateCorrect(request.getParameter("start"))
                || !validator.isLimitCorrect(request.getParameter("limit"))) {
            throw new IllegalArgumentException();
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("faculty", request.getParameter("faculty"));
        parameters.put("specialty", request.getParameter("specialty"));
        parameters.put("limit", Long.valueOf(request.getParameter("limit")));
        return parameters;
    }
}
