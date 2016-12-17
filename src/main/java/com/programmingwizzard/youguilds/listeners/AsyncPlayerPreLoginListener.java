package com.programmingwizzard.youguilds.listeners;

import com.programmingwizzard.youguilds.api.YouAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class AsyncPlayerPreLoginListener implements Listener
{
    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event)
    {
        UUID uuid = event.getUniqueId();
        if (uuid == null)
        {
            return;
        }
        YouAPI.getUserManager().createNewUser(uuid);
    }
}
