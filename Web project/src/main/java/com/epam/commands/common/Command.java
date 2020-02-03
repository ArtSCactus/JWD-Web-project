package com.epam.commands.common;

import com.epam.commands.result.CommandResult;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandResult execute(HttpServletRequest request);
}
