package com.epam.common;

import com.epam.commands.Command;
import com.epam.commands.CommandEnum;
import com.epam.commands.ShowCommand;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static final String COMMAND = "command";

    public Command defineCommand(HttpServletRequest request) {
        Command current = new ShowCommand();
        String action = request.getParameter(COMMAND);
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException ex) {
            request.setAttribute("wrongAction", action + "command not found or wrong!");
        }
        return current;
    }
}
