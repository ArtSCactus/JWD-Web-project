package com.epam.commands.main;

import com.epam.commands.result.ForwardCommand;
import com.epam.commands.authorization.LoginCommand;
import com.epam.commands.authorization.LogoutCommand;
import com.epam.commands.controlpanel.ChangeApplicationStatusCommand;
import com.epam.commands.controlpanel.ShowControlPanelCommand;

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
    SHOW_CONTROL_PANEL {
        {
            this.command = new ShowControlPanelCommand();
        }
    },
    CHANGE_APPLICATION_STATUS {
        {
            this.command = new ChangeApplicationStatusCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }

}
