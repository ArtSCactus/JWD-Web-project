package com.epam.commands;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    FORWARD{
        {
            this.command = new ForwardCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
