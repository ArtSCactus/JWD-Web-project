package com.epam.commands.main;

import com.epam.commands.controlpanel.get.ShowStudentsCommand;
import com.epam.commands.controlpanel.post.ChangeBlockStatusCommand;
import com.epam.commands.controlpanel.get.ShowAccountsCommand;
import com.epam.commands.controlpanel.get.ShowAdmissionsCommand;
import com.epam.commands.controlpanel.post.ExpelStudentCommand;
import com.epam.commands.controlpanel.post.FinishAdmissionCommand;
import com.epam.commands.result.ForwardCommand;
import com.epam.commands.authorization.post.LoginCommand;
import com.epam.commands.authorization.post.LogoutCommand;
import com.epam.commands.controlpanel.post.ChangeApplicationStatusCommand;
import com.epam.commands.controlpanel.get.ShowApplicationsCommand;

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
            this.command = new ShowApplicationsCommand();
        }
    },
    CHANGE_APPLICATION_STATUS {
        {
            this.command = new ChangeApplicationStatusCommand();
        }
    },
    CHANGE_BLOCK_STATUS{
        {
          this.command = new ChangeBlockStatusCommand();
        }
    },
    SHOW_ADMIN_PANEL {
        {
            this.command = new ShowApplicationsCommand();
        }
    },
    SHOW_APPLICATIONS_PANEL{
        {
            this.command = new ShowApplicationsCommand();
        }
    },
    SHOW_ACCOUNTS_PANEL{
        {
            this.command = new ShowAccountsCommand();
        }
    },
    SHOW_ADMISSIONS_PANEL{
        {
            this.command = new ShowAdmissionsCommand();
        }
    },
    FINISH_ADMISSION {
        {
            this.command = new FinishAdmissionCommand();
        }
    },
    SHOW_STUDENTS_PANEL{
        {
            this.command = new ShowStudentsCommand();
        }
    },
    EXPEL_STUDENT{
        {
            this.command = new ExpelStudentCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }

}
