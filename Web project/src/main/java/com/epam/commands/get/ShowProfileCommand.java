package com.epam.commands.get;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;
import com.epam.model.dto.PageContent;
import com.epam.model.dto.entity.Account;
import com.epam.model.dto.entity.Application;
import com.epam.model.dto.entity.Student;
import com.epam.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class ShowProfileCommand implements Command {
    private static final String ERROR_PAGE_PATH = "/WEB-INF/jsp/stacktrace page.jsp";
    private static final String PROFILE_PAGE_PATH = "/WEB-INF/jsp/main/profile.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long accountId = (Long) session.getAttribute("accountId");
        ApplicationService applicationService = new ApplicationService();
        AccountService accountService = new AccountService();
        PageContent content = new PageContent();
        Optional<Account> accountOptional = accountService.getAccountById(accountId);
        if (!accountOptional.isPresent()){
            request.setAttribute("message", "Requesting account does not exist.");
            return new CommandResult(ERROR_PAGE_PATH, CommandType.POST);
        }
        Account account = accountOptional.get();
        if (account.getStudentId()!=null & account.getStudentId()!=0){
            // Existing of student id is guaranteed by database
            Student student = new StudentService().getById(account.getStudentId()).get();
            String facultyName = new FacultyService().getFacultyNameById(student.getFacultyId());
            String specialtyName = new SpecialtyService().getSpecialtyNameById(student.getSpecialtyId());
            content.setAttribute("specialtyName", specialtyName);
            content.setAttribute("facultyName", facultyName);
        }
        List<Application> applicationsHistory = applicationService.getApplicationsByAccountId(accountId);
        content.setAttribute("applicationHistory", applicationsHistory);
        content.setAttribute("account", account);
        request.setAttribute("pageContent", content);
        return new CommandResult(PROFILE_PAGE_PATH, CommandType.GET);
    }
}
