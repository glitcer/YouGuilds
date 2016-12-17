package com.programmingwizzard.youguilds.commands;

import com.programmingwizzard.youguilds.commands.arguments.PlayerInfoArgument;
import com.programmingwizzard.youguilds.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class GuildCommand implements CommandExecutor
{
    private final Set<GuildArgument> guildArguments = new HashSet<>();
    {
        this.guildArguments.add(new PlayerInfoArgument());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if (!(commandSender instanceof Player))
        {
            return true;
        }
        if (strings.length == 0)
        {
            ChatUtils.sendMessage(commandSender, "&8========== [ &6youGuilds &8] ==========");
            ChatUtils.sendMessage(commandSender, "&7Dostepne komendy:");
            this.guildArguments.forEach(guildArgument -> ChatUtils.sendMessage(commandSender, "&8-  &7/" + guildArgument.getArgument() + " &8- &6" + guildArgument.getDescription()));
            return ChatUtils.sendMessage(commandSender, "&8========== [ &6youGuilds &8] ==========");
        }
        GuildArgument argument = this.guildArguments.stream().filter(guildArgument -> guildArgument.getArgument().equals(strings[0])).findFirst().orElse(null);
        if (argument == null)
        {
            ChatUtils.sendMessage(commandSender, "&8========== [ &6youGuilds &8] ==========");
            ChatUtils.sendMessage(commandSender, "&7Dostepne komendy:");
            this.guildArguments.forEach(guildArgument -> ChatUtils.sendMessage(commandSender, "&8-  &7/" + guildArgument.getArgument() + " &8- &6" + guildArgument.getDescription()));
            return ChatUtils.sendMessage(commandSender, "&8========== [ &6youGuilds &8] ==========");
        }
        argument.handle((Player) commandSender, strings);
        return true;
    }
}
