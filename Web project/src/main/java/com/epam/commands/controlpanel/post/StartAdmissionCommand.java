package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.message.MessageGenerator;
import com.epam.model.dto.entity.NewsFeedItem;
import com.epam.service.AdmissionService;
import com.epam.service.NewsFeedService;
import com.epam.service.UniversityService;
import com.epam.validator.AdmissionValidator;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
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
            Long limit = (Long) parameters.get("limit");
            admissionService.startAdmission(facultyId, specialtyId,
                    (Date) parameters.get("end"), limit.intValue());
            boolean isShouldBeCreatedNewsFeedItem = (boolean) parameters.get("notification");

            if (isShouldBeCreatedNewsFeedItem) {
                MessageGenerator generator = new MessageGenerator();
                NewsFeedService newsFeedService = new NewsFeedService();
                String facultyName = universityService.getFacultyNameById(facultyId);
                String specialtyName = universityService.getSpecialtyNameById(specialtyId);
                newsFeedService.update(generator.generateAdmissionStartMessage(facultyName, specialtyName,
                         limit+""));
            }

            return new CommandResult(REDIRECT_URL, CommandType.POST);

        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "One of the fields is incorrect." +
                    " Please, validate the fields and try again");
            return new CommandResult(REDIRECT_URL, CommandType.GET);
        }
    }

    private Map<String, Object> getParameters(HttpServletRequest request) {
        AdmissionValidator validator = new AdmissionValidator();

        if (!validator.isDateCorrect(request.getParameter("end"))
                || !validator.isLimitCorrect(request.getParameter("limit"))) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("faculty", request.getParameter("faculty"));
        parameters.put("specialty", request.getParameter("specialty"));
        parameters.put("limit", Long.valueOf(request.getParameter("limit")));
        parameters.put("end", Date.valueOf(request.getParameter("end")));
        parameters.put("notification", Boolean.parseBoolean(request.getParameter("notification")));

        return parameters;
    }
}
