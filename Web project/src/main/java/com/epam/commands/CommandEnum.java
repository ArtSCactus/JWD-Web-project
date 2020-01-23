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
    },
    SHOW_CONTROL_PANEL{
        {
            this.command = new ShowControlPanelCommand();
        }
    },
    ACCEPT_APPLICATION{
        {
            this.command = new AcceptApplicationCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }

}
