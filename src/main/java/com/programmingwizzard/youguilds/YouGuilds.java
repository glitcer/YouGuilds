package com.programmingwizzard.youguilds;

import com.programmingwizzard.youguilds.api.API;
import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.managers.UserManager;
import com.programmingwizzard.youguilds.impl.managers.UserManagerImpl;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class YouGuilds extends JavaPlugin implements API
{
    private final UserManager userManager = new UserManagerImpl();

    @Override
    public void onLoad()
    {
        try
        {
            YouAPI.setAPI(this);
        }
        catch (IllegalAccessException ex)
        {
            YouAPI.getLogger().log(Level.SEVERE, "Failed to initializing YouGuilds!", ex);
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onEnable()
    {
        YouAPI.getUserManager().loadAll();
    }

    @Override
    public void onDisable()
    {
        YouAPI.getUserManager().saveAll();
    }

    @Override
    public void runAsync(Runnable runnable)
    {
        this.getServer().getScheduler().runTask(this, runnable);
    }

    @Override
    public void runAsyncTimer(Runnable runnable, long period)
    {
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, runnable, period, period);
    }

    @Override
    public UserManager getUserManager()
    {
        return this.userManager;
    }
}
