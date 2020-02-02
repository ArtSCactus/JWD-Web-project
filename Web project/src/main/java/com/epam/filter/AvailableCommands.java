package com.epam.filter;

import com.epam.commands.main.CommandEnum;

import java.util.ArrayList;
import java.util.List;

public class AvailableCommands {
   public static List<CommandEnum> getUserCommands(){
       List<CommandEnum> commands = new ArrayList<>();
       commands.add(CommandEnum.APPLY);
       commands.add(CommandEnum.LOGIN);
       commands.add(CommandEnum.LOGOUT);
       commands.add(CommandEnum.FORWARD);
       commands.add(CommandEnum.SIGN_UP);
       return commands;
   }

   public static List<CommandEnum> getAdminCommands(){
       List<CommandEnum> commands = new ArrayList<>(getUserCommands());
       commands.add(CommandEnum.SHOW_CONTROL_PANEL);
       commands.add(CommandEnum.CHANGE_BLOCK_STATUS);
       commands.add(CommandEnum.SHOW_ADMIN_PANEL);
       commands.add(CommandEnum.SHOW_ACCOUNTS_PANEL);
       commands.add(CommandEnum.SHOW_APPLICATIONS_PANEL);
       commands.add(CommandEnum.CHANGE_APPLICATION_STATUS);
       commands.add(CommandEnum.SHOW_ADMISSIONS_PANEL);
       commands.add(CommandEnum.CHANGE_ADMISSION_STATUS);
       commands.add(CommandEnum.SHOW_STUDENTS_PANEL);
       commands.add(CommandEnum.EXPEL_STUDENT);
       commands.add(CommandEnum.START_ADMISSION);
       return commands;
   }
}
