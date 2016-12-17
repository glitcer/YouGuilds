package com.programmingwizzard.youguilds.commands.arguments;

import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.commands.GuildArgument;
import com.programmingwizzard.youguilds.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class PlayerInfoArgument implements GuildArgument
{
    @Override
    @SuppressWarnings("deprecated")
    public void handle(Player player, String[] args)
    {
        if (args.length == 1)
        {
            ChatUtils.sendMessage(player, "&7Poprawne uzycie: &6/guild pinfo [nick]");
            return;
        }
        OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
        if (p == null)
        {
            ChatUtils.sendMessage(player, "&7Taki gracz nie istnieje");
            return;
        }
        User user = YouAPI.getUserManager().get(p.getUniqueId());
        if (user == null)
        {
            ChatUtils.sendMessage(player, "&7Taki gracz nie istnieje");
            return;
        }
        ChatUtils.sendMessage(player, "&8========== [ &6youGuilds &8] ==========");
        ChatUtils.sendMessage(player, "&7Gracz: &6" + p.getName());
        ChatUtils.sendMessage(player, "&7Ranking: &6" + user.getRank().getRank());
        ChatUtils.sendMessage(player, "&7Zabojstwa: &6" + user.getRank().getKills());
        ChatUtils.sendMessage(player, "&7Smierci: &6" + user.getRank().getDeaths());
        ChatUtils.sendMessage(player, "&8========== [ &6youGuilds &8] ==========");
    }

    @Override
    public String getArgument()
    {
        return "pinfo";
    }

    @Override
    public String getDescription()
    {
        return "Sprawdz statystyki gracza!";
    }
}
