package com.epam.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**Default command, that uses in case of undefined command.
 *
 */
public class DefaultCommand implements Command {
    private static final String MAIN_PAGE_PATH = "/WEB-INF/main.jsp";

    public CommandResult execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("isUserDefined", false);
        return new CommandResult(MAIN_PAGE_PATH);
    }
}
