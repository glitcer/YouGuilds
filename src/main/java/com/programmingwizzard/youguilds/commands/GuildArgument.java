package com.programmingwizzard.youguilds.commands;

import org.bukkit.entity.Player;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface GuildArgument
{
    void handle(Player player, String[] args);

    String getArgument();

    String getDescription();
}
