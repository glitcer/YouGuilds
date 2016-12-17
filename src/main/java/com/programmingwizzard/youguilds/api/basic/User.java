package com.programmingwizzard.youguilds.api.basic;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface User
{
    UUID getUUID();

    Rank getRank();

    Guild getGuild();

    void setGuild(Guild guild);

    default OfflinePlayer getOfflinePlayer()
    {
        if (this.getUUID() == null)
        {
            throw new NullPointerException("UUID can not be null");
        }
        return Bukkit.getOfflinePlayer(this.getUUID());
    }

    default Player getOnlinePlayer()
    {
        if (this.getUUID() == null)
        {
            throw new NullPointerException("UUID can not be null");
        }
        return Bukkit.getPlayer(this.getUUID());
    }
}
