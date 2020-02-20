package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.message.MessageGenerator;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.*;
import com.epam.service.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;
import java.util.*;

/**
 * @author ArtSCactus
 * @version 0.1.2
 */
public class ChangeAdmissionStatusCommand implements Command {
    private static final String REDIRECT_URL = "/controller?command=show_admissions_panel";
    private static final String ADMISSIONS_TABLE_PAGE_PATH = "/WEB-INF/jsp/control panel/admission table.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        boolean newAdmissionStatus = Boolean.parseBoolean(request.getParameter("newStatus"));
     if (newAdmissionStatus){
         return resumeAdmission(request);
     } else {
         return  finishAdmission(request);
     }
    }
    private CommandResult finishAdmission(HttpServletRequest request){
        Long admissionId = Long.parseLong(request.getParameter("admissionId"));
        AdmissionService admissionService = new AdmissionService();
        ApplicationService applicationService = new ApplicationService();
        StudentService studentService = new StudentService();
        boolean isNotificationRequired = Boolean.parseBoolean(request.getParameter("notification"));
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
                        Date.valueOf(LocalDate.now(Clock.systemDefaultZone())),
                        StudentStatus.ENROLLED));
            }
            studentService.enrollStudents(studentList);
            if (isNotificationRequired){
                createNewsNoteWhenCompleting(admission.getFacultyId(), admission.getSpecialtyId(), studentList);
            }
            return new CommandResult(REDIRECT_URL, CommandType.POST);
        } else {
            return new CommandResult(ADMISSIONS_TABLE_PAGE_PATH, CommandType.GET);
        }
    }

    private CommandResult resumeAdmission(HttpServletRequest request){
        Long admissionId = Long.parseLong(request.getParameter("admissionId"));
        AdmissionService admissionService = new AdmissionService();
        boolean isNotificationRequired = Boolean.parseBoolean(request.getParameter("notification"));
        Optional<Admission> admissionOptional = admissionService.getAdmissionById(admissionId);
        if (admissionOptional.isPresent()){
         Admission admission = admissionOptional.get();
         admission.setStatus(true);
         admissionService.updateAdmission(admission);
         if (isNotificationRequired){
             createNewsNoteWhenResuming(admission.getFacultyId(), admission.getSpecialtyId());
         }
         return new CommandResult(REDIRECT_URL, CommandType.POST);
        }
        return new CommandResult(ADMISSIONS_TABLE_PAGE_PATH, CommandType.GET);
    }

    private void createNewsNoteWhenCompleting(Long facultyId, Long specialtyId, List<Student> students){
        NewsFeedService newsService = new NewsFeedService();
        MessageGenerator generator = new MessageGenerator();
        String facultyName = new FacultyService().getFacultyNameById(facultyId);
        String specialtyName = new SpecialtyService().getSpecialtyNameById(specialtyId);
        NewsFeedItem item = generator.generateAdmissionCompletionMessage(facultyName, specialtyName, students);
        newsService.update(item);
    }

    private void createNewsNoteWhenResuming(Long facultyId, Long specialtyId){
        NewsFeedService newsService = new NewsFeedService();
        MessageGenerator generator = new MessageGenerator();
        String facultyName = new FacultyService().getFacultyNameById(facultyId);
        String specialtyName = new SpecialtyService().getSpecialtyNameById(specialtyId);
        NewsFeedItem item = generator.generateAdmissionResumeMessage(facultyName, specialtyName);
        newsService.update(item);
    }
}
