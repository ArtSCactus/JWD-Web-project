package com.epam.commands.controlpanel.post;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.dto.entity.Admission;
import com.epam.dto.entity.Application;
import com.epam.dto.entity.Student;
import com.epam.service.AdmissionService;
import com.epam.service.ApplicationService;
import com.epam.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class FinishAdmissionCommand implements Command {
    private static final String REDIRECT_URL = "/controller?command=show_admissions_panel";
    private static final String ADMISSIONS_TABLE_PAGE_PATH = "/WEB-INF/jsp/control panel/admission table.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long admissionId = Long.parseLong(request.getParameter("admissionId"));
        AdmissionService admissionService = new AdmissionService();
        ApplicationService applicationService = new ApplicationService();
        StudentService studentService = new StudentService();
        Optional<Admission> admissionOptional = admissionService.getAdmissionById(admissionId);
        if (admissionOptional.isPresent()) {
            Admission admission = admissionOptional.get();
            admissionService.endAdmission(admissionId);
            List<Application> enrolledApplications = applicationService.getEnrolledApplications(admission);
            List<Student> studentList = new ArrayList<>();
            for (Application application : enrolledApplications) {
                studentList.add(new Student(null,
                        application.getAccountId(),
                        application.getFacultyId(),
                        application.getSpecialtyId(),
                        Date.valueOf(LocalDate.now(Clock.systemDefaultZone()))));
            }
            studentService.enrollStudents(studentList);
            return new CommandResult(null, REDIRECT_URL, CommandType.POST);
        } else {
            return new CommandResult(ADMISSIONS_TABLE_PAGE_PATH, null, CommandType.GET);
        }
    }
}
