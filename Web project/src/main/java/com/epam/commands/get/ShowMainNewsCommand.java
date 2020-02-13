package com.epam.commands.get;

import com.epam.commands.common.Command;
import com.epam.commands.result.CommandResult;
import com.epam.commands.result.CommandType;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class ShowMainNewsCommand implements Command {
    private static final String REDIRECTION_URL = "/WEB-INF/jsp/main/news.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(REDIRECTION_URL, CommandType.GET);
    }
}
