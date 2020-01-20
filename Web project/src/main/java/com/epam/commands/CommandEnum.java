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
    FORWARD {
        {
            this.command = new ForwardCommand();
        }
    },
    APPLY {
        {
            this.command = new ApplyCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
