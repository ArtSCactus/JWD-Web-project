package com.epam.factory;

import com.epam.commands.common.Command;
import com.epam.commands.common.CommandEnum;
import com.epam.commands.get.DefaultCommand;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static final String COMMAND = "command";

    public Command defineCommand(HttpServletRequest request) {
        Command current = new DefaultCommand();
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
