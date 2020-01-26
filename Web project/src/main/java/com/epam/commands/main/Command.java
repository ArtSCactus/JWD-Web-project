package com.epam.commands.main;

import com.epam.commands.result.CommandResult;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandResult execute(HttpServletRequest request);
}
