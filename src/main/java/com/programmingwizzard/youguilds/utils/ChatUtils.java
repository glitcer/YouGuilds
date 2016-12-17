package com.programmingwizzard.youguilds.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class ChatUtils
{
    public static boolean sendMessage(CommandSender sender, String message)
    {
        if (message == null || message.isEmpty() || sender == null)
        {
            throw new NullPointerException("Message or Sender can not be null!");
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        return true;
    }
}
