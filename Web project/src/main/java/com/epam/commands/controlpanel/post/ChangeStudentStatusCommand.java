package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.entity.Student;
import com.epam.model.dto.entity.StudentStatus;
import com.epam.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ChangeStudentStatusCommand implements Command {
    private static final String REDIRECT_TO_STUDENTS = "/controller?command=show_students_panel";
    private static final String REDIRECT_TO_404 = "/WEB-INF/jsp/stacktrace page.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("studentId"));
        StudentService service = new StudentService();
        Optional<Student> studentOptional = service.getById(id);

        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            String statusValue = request.getParameter("status");
            StudentStatus status = StudentStatus.valueOf(statusValue.toUpperCase());
            student.setStatus(status);
            service.update(student);
            return new CommandResult(REDIRECT_TO_STUDENTS, CommandType.POST);

        } else {
            request.setAttribute("message", "No student with id: "+id+" found.");
            return new CommandResult(REDIRECT_TO_404, CommandType.GET);
        }
    }
}
