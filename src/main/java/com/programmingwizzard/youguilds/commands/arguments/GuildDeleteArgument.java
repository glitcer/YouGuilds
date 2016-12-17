package com.programmingwizzard.youguilds.commands.arguments;

import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.commands.GuildArgument;
import com.programmingwizzard.youguilds.utils.ChatUtils;
import org.bukkit.entity.Player;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class GuildDeleteArgument implements GuildArgument
{
    @Override
    public void handle(Player player, String[] args)
    {
        User user = YouAPI.getUserManager().get(player.getUniqueId());
        if (user.getGuild() == null)
        {
            ChatUtils.sendMessage(player, "&7Nie nalezysz do zadnej gildii!");
            return;
        }
        if (!user.getGuild().getLeader().getUUID().equals(user.getUUID()))
        {
            ChatUtils.sendMessage(player, "&7Nie jestes liderem gildii!");
            return;
        }
        user.getGuild().delete();
        ChatUtils.sendMessage(player, "&7Poprawnie usunieto gildie!");
    }

    @Override
    public String getArgument()
    {
        return "delete";
    }

    @Override
    public String getDescription()
    {
        return "Usuwanie wlasnej gildii!";
    }
}
