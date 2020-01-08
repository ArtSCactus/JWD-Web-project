package com.epam.common;

import com.epam.commands.ActionCommand;
import com.epam.commands.CommandEnum;
import com.epam.commands.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static String COMMAND = "command";

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
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
