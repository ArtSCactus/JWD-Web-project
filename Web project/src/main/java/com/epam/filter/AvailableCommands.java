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
       return commands;
   }
}
