package com.epam.filter;

import com.epam.commands.CommandEnum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AccessFilter implements Filter {
    private static final String COMMAND_PARAM = "command";
    private static final String ACCESS_DENIED_PAGE = "/WEB-INF/jsp/access denied.jsp";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
       HttpSession session = httpServletRequest.getSession();
       boolean isUserAdmin = (boolean) session.getAttribute("isUserAdmin");
        List<CommandEnum> commands = getAvailableCommands(isUserAdmin);
        String requestingCommand = httpServletRequest.getParameter(COMMAND_PARAM).toUpperCase();
        CommandEnum requestingCommandObj = CommandEnum.valueOf(requestingCommand);
        if (commands.contains(requestingCommandObj)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(ACCESS_DENIED_PAGE);
            requestDispatcher.forward(servletRequest, servletResponse);
        }
    }

    private List<CommandEnum> getAvailableCommands(boolean isUserAdmin) {
        if (isUserAdmin) {
            return AvailableCommands.getAdminCommands();
        } else {
            return AvailableCommands.getUserCommands();
        }
    }
}