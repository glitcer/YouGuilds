package com.programmingwizzard.youguilds.commands.arguments;

import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.basic.Guild;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.commands.GuildArgument;
import com.programmingwizzard.youguilds.utils.ChatUtils;
import org.bukkit.entity.Player;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class GuildCreateArgument implements GuildArgument
{
    @Override
    public void handle(Player player, String[] args)
    {
        if (args.length != 3)
        {
            ChatUtils.sendMessage(player, "&7Poprawne uzycie: &6/guild create [tag] [nazwa]");
            return;
        }
        User user = YouAPI.getUserManager().get(player.getUniqueId());
        Guild guild = YouAPI.getGuildManager().createNewGuild(args[1], args[2], user);
        if (guild == null)
        {
            ChatUtils.sendMessage(player, "&7Taka gildia juz istnieje!");
            return;
        }
        guild.getUsers().add(user);
        ChatUtils.sendMessage(player, "&7Poprawnie zalozono gildie!");
    }

    @Override
    public String getArgument()
    {
        return "create";
    }

    @Override
    public String getDescription()
    {
        return "Komenda pozwalajaca stworzyc wlasna gildie!";
    }
}
