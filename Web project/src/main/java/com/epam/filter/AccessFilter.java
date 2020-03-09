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
    private static final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/login.jsp";
    private List<CommandEnum> authorizedUserCommands;
    private List<CommandEnum> adminCommands;
    private List<CommandEnum> unauthorizedUserCommands;

    @Override
    public void init(FilterConfig config) {
        unauthorizedUserCommands = new ArrayList<>();
        unauthorizedUserCommands.add(CommandEnum.SIGN_UP);
        unauthorizedUserCommands.add(CommandEnum.LOGIN);
        unauthorizedUserCommands.add(CommandEnum.SHOW_MAIN_PAGE);
        authorizedUserCommands = new ArrayList<>();
        authorizedUserCommands.add(CommandEnum.APPLY);
        authorizedUserCommands.add(CommandEnum.LOGIN);
        authorizedUserCommands.add(CommandEnum.LOGOUT);
        authorizedUserCommands.add(CommandEnum.FORWARD);
        authorizedUserCommands.add(CommandEnum.SIGN_UP);
        authorizedUserCommands.add(CommandEnum.SHOW_MAIN_PAGE);
        authorizedUserCommands.add(CommandEnum.CHANGE_LANGUAGE);
        authorizedUserCommands.add(CommandEnum.CANCEL);
        authorizedUserCommands.add(CommandEnum.NEWS);
        authorizedUserCommands.add(CommandEnum.SHOW_PROFILE);
        adminCommands = new ArrayList<>(authorizedUserCommands);
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
        Long accountId = (Long) session.getAttribute("accountId");
        AccountService service = new AccountService();
        boolean isUserAdmin = (boolean) session.getAttribute("isUserAdmin");
        List<CommandEnum> commands;

        if (accountId == null) {
            commands = unauthorizedUserCommands;
        } else {
            if (isUserAdmin) {
                commands = adminCommands;
            } else {
                commands = authorizedUserCommands;
            }
        }

        String requestingCommand = httpServletRequest.getParameter(COMMAND_PARAM).toUpperCase();
        CommandEnum requestingCommandObj = CommandEnum.valueOf(requestingCommand);
        if (accountId == null) {
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
