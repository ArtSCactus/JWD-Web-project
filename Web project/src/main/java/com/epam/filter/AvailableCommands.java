package com.epam.filter;

import com.epam.commands.common.CommandEnum;

import java.util.ArrayList;
import java.util.List;

public class AvailableCommands {
    //TODO: To filter
    private static List<CommandEnum> userCommands;
    private static List<CommandEnum> adminCommands;

    public static List<CommandEnum> getUserCommands() {
        if (userCommands == null) {
            userCommands = new ArrayList<>();
            userCommands.add(CommandEnum.APPLY);
            userCommands.add(CommandEnum.LOGIN);
            userCommands.add(CommandEnum.LOGOUT);
            userCommands.add(CommandEnum.FORWARD);
            userCommands.add(CommandEnum.SIGN_UP);
            userCommands.add(CommandEnum.SHOW_MAIN_PAGE);
            userCommands.add(CommandEnum.CHANGE_LANGUAGE);
            userCommands.add(CommandEnum.CANCEL);
            return userCommands;
        }
        return userCommands;
    }

    public static List<CommandEnum> getAdminCommands() {
        if (adminCommands == null) {
            adminCommands = new ArrayList<>(getUserCommands());
            adminCommands.add(CommandEnum.SHOW_CONTROL_PANEL);
            adminCommands.add(CommandEnum.CHANGE_BLOCK_STATUS);
            adminCommands.add(CommandEnum.SHOW_ADMIN_PANEL);
            adminCommands.add(CommandEnum.SHOW_ACCOUNTS_PANEL);
            adminCommands.add(CommandEnum.SHOW_APPLICATIONS_PANEL);
            adminCommands.add(CommandEnum.CHANGE_APPLICATION_STATUS);
            adminCommands.add(CommandEnum.SHOW_ADMISSIONS_PANEL);
            adminCommands.add(CommandEnum.CHANGE_ADMISSION_STATUS);
            adminCommands.add(CommandEnum.SHOW_STUDENTS_PANEL);
            adminCommands.add(CommandEnum.EXPEL_STUDENT);
            adminCommands.add(CommandEnum.START_ADMISSION);
        }
        return adminCommands;
    }
}
