package com.epam.filter;

import com.epam.commands.CommandEnum;

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
       List<CommandEnum> commands = new ArrayList<>();
       commands.addAll(getUserCommands());
       commands.add(CommandEnum.SHOW_CONTROL_PANEL);
       return commands;
   }
}
