package com.epam.commands.post;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class SwitchLanguageCommand implements Command {
    private static final String LANGUAGE = "lang";
    private static final String REDIRECT_TO_MAIN_PAGE ="/controller?command=show_main_page";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        String newLanguage = request.getParameter(LANGUAGE).toUpperCase();
        HttpSession session = request.getSession();
        session.setAttribute(LANGUAGE, newLanguage);
        return new CommandResult(REDIRECT_TO_MAIN_PAGE, CommandType.POST);
    }
}
