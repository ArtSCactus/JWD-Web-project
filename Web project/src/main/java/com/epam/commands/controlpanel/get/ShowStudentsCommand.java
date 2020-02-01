package com.epam.commands.controlpanel.get;

import com.epam.commands.main.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.dto.PageContent;
import com.epam.dto.entity.Student;
import com.epam.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowStudentsCommand implements Command {
    private static final String STUDENT_TABLE_PAGE_PATH = "/WEB-INF/jsp/control panel/students table.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        StudentService service = new StudentService();
        List<Student> studentList = service.getStudentList();
        PageContent content = new PageContent();
        content.setContent(studentList);
        request.setAttribute("content", content);
        return new CommandResult(STUDENT_TABLE_PAGE_PATH, CommandType.GET);
    }
}
