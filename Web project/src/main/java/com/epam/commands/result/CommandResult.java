package com.epam.commands.result;

import java.util.Objects;
public class CommandResult {
    private String url;
    private String redirectUrl;
    private CommandType executedCommandType;

    public CommandResult(String url, String redirectUrl, CommandType executedCommandType) {
        this.url = url;
        this.redirectUrl = redirectUrl;
        this.executedCommandType = executedCommandType;
    }

    public CommandResult(String url, String redirectUrl) {
        this.url = url;
        this.redirectUrl = redirectUrl;
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

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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
        return Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getRedirectUrl(), that.getRedirectUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getRedirectUrl());
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "url='" + url + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
