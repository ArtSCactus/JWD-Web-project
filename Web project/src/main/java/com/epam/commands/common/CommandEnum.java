package com.epam.commands.common;

import com.epam.commands.authorization.post.SignUpCommand;
import com.epam.commands.controlpanel.get.ShowStudentsCommand;
import com.epam.commands.controlpanel.post.*;
import com.epam.commands.controlpanel.get.ShowAccountsCommand;
import com.epam.commands.controlpanel.get.ShowAdmissionsCommand;
import com.epam.commands.get.ShowMainNewsCommand;
import com.epam.commands.get.ShowMainPageCommand;
import com.epam.commands.get.SwitchLanguageCommand;
import com.epam.commands.post.ApplyCommand;
import com.epam.commands.post.CancelCommand;
import com.epam.commands.result.ForwardCommand;
import com.epam.commands.authorization.post.LoginCommand;
import com.epam.commands.authorization.post.LogoutCommand;
import com.epam.commands.controlpanel.get.ShowApplicationsCommand;

public enum CommandEnum {
    //TODO: To CommandFactory
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
    SHOW_MAIN_PAGE {
        {
            this.command = new ShowMainPageCommand();
        }
    },
    SHOW_CONTROL_PANEL {
        {
            this.command = new ShowApplicationsCommand();
        }
    },
    CHANGE_APPLICATION_STATUS {
        {
            this.command = new ChangeApplicationStatusCommand();
        }
    },
    CHANGE_BLOCK_STATUS {
        {
            this.command = new ChangeBlockStatusCommand();
        }
    },
    SHOW_ADMIN_PANEL {
        {
            this.command = new ShowApplicationsCommand();
        }
    },
    SHOW_APPLICATIONS_PANEL {
        {
            this.command = new ShowApplicationsCommand();
        }
    },
    SHOW_ACCOUNTS_PANEL {
        {
            this.command = new ShowAccountsCommand();
        }
    },
    SHOW_ADMISSIONS_PANEL {
        {
            this.command = new ShowAdmissionsCommand();
        }
    },
    CHANGE_ADMISSION_STATUS {
        {
            this.command = new ChangeAdmissionStatusCommand();
        }
    },
    SHOW_STUDENTS_PANEL {
        {
            this.command = new ShowStudentsCommand();
        }
    },
    EXPEL_STUDENT {
        {
            this.command = new ChangeStudentStatusCommand();
        }
    },
    START_ADMISSION {
        {
            this.command = new StartAdmissionCommand();
        }
    },
    SIGN_UP {
        {
            this.command = new SignUpCommand();
        }
    },
    CHANGE_LANGUAGE {
        {
            this.command = new SwitchLanguageCommand();
        }
    },
    CANCEL {
        {
            this.command = new CancelCommand();
        }
    },
    NEWS{
        {
            this.command = new ShowMainNewsCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }

}
