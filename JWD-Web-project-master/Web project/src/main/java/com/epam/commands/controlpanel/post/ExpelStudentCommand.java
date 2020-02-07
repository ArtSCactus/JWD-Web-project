package com.epam.commands.controlpanel.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.model.dto.entity.Student;
import com.epam.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ExpelStudentCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("studentId"));
        StudentService service = new StudentService();
        Optional<Student> studentOptional = service.getById(id);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            //TODO: set status expelled here. Add status to student table.
        }
        return null;
    }
}
