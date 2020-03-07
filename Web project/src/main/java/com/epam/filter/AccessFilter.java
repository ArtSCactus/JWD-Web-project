package com.epam.filter;

import com.epam.commands.common.CommandEnum;
import com.epam.service.AccountService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessFilter implements Filter {
    private static final String COMMAND_PARAM = "command";
    private static final String ACCESS_DENIED_PAGE = "/WEB-INF/jsp/access denied.jsp";
    private static final String LOGIN_PAGE_PATH="/WEB-INF/jsp/login.jsp";
    private List<CommandEnum> userCommands;
    private List<CommandEnum> adminCommands;

    @Override
    public void init(FilterConfig filterConfig){
        userCommands = new ArrayList<>();
        userCommands.add(CommandEnum.APPLY);
        userCommands.add(CommandEnum.LOGIN);
        userCommands.add(CommandEnum.LOGOUT);
        userCommands.add(CommandEnum.FORWARD);
        userCommands.add(CommandEnum.SIGN_UP);
        userCommands.add(CommandEnum.SHOW_MAIN_PAGE);
        userCommands.add(CommandEnum.CHANGE_LANGUAGE);
        userCommands.add(CommandEnum.CANCEL);
        userCommands.add(CommandEnum.NEWS);
        adminCommands = new ArrayList<>(userCommands);
        adminCommands.add(CommandEnum.SHOW_CONTROL_PANEL);
        adminCommands.add(CommandEnum.CHANGE_BLOCK_STATUS);
        adminCommands.add(CommandEnum.SHOW_ADMIN_PANEL);
        adminCommands.add(CommandEnum.SHOW_ACCOUNTS_PANEL);
        adminCommands.add(CommandEnum.SHOW_APPLICATIONS_PANEL);
        adminCommands.add(CommandEnum.CHANGE_APPLICATION_STATUS);
        adminCommands.add(CommandEnum.SHOW_ADMISSIONS_PANEL);
        adminCommands.add(CommandEnum.CHANGE_ADMISSION_STATUS);
        adminCommands.add(CommandEnum.SHOW_STUDENTS_PANEL);
        adminCommands.add(CommandEnum.EXPEL_STUDENT);
        adminCommands.add(CommandEnum.START_ADMISSION);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
       HttpSession session = httpServletRequest.getSession();
        AccountService service = new AccountService();
       boolean isUserAdmin = (boolean) session.getAttribute("isUserAdmin");
        List<CommandEnum> commands;
        if (isUserAdmin){
           commands = adminCommands;
       } else {
            commands = userCommands;
        }
       Long accountId = (Long) session.getAttribute("accountId");
        String requestingCommand = httpServletRequest.getParameter(COMMAND_PARAM).toUpperCase();
        CommandEnum requestingCommandObj = CommandEnum.valueOf(requestingCommand);
        if (accountId==null){
        if (commands.contains(requestingCommandObj)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(LOGIN_PAGE_PATH);
                requestDispatcher.forward(servletRequest, servletResponse);
        }
        } else {
            boolean isAccountBlocked = service.isAccountBlocked(accountId);
            if (commands.contains(requestingCommandObj) & !isAccountBlocked) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                if (isAccountBlocked) {
                    HttpSession httpSession = httpServletRequest.getSession();
                    httpSession.invalidate();
                }
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(ACCESS_DENIED_PAGE);
                requestDispatcher.forward(servletRequest, servletResponse);
            }
        }
    }
}
