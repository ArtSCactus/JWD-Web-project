package com.epam.commands.result;

import java.util.Map;
import java.util.Objects;

public class CommandResult {
    private String url;
    private CommandType executedCommandType;

    public CommandResult(String url, CommandType executedCommandType) {
        this.url = url;
        this.executedCommandType = executedCommandType;
    }

    public CommandResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CommandType getExecutedCommandType() {
        return executedCommandType;
    }

    public void setExecutedCommandType(CommandType executedCommandType) {
        this.executedCommandType = executedCommandType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandResult)) return false;
        CommandResult that = (CommandResult) o;
        return Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl());
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "url='" + url + '\'' + '}';
    }
}
