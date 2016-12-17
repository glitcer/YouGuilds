package com.programmingwizzard.youguilds;

import com.programmingwizzard.youguilds.api.API;
import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.db.Database;
import com.programmingwizzard.youguilds.api.managers.UserManager;
import com.programmingwizzard.youguilds.impl.managers.UserManagerImpl;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class YouGuilds extends JavaPlugin implements API
{
    private final UserManager userManager = new UserManagerImpl();

    private boolean status = true;
    private Database database;

    @Override
    public void onLoad()
    {
        try
        {
            YouAPI.setAPI(this);
        }
        catch (IllegalAccessException ex)
        {
            status = false;
            YouAPI.getLogger().log(Level.SEVERE, "Error in plugin YouGuilds!", ex);
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onEnable()
    {
        if (!this.getDataFolder().exists())
        {
            this.getDataFolder().mkdir();
        }
        File file = new File(this.getDataFolder(), "sqlite.db");
        try
        {
            if (!file.exists())
            {
                file.createNewFile();
            }
        }
        catch (IOException ex)
        {
            status = false;
            YouAPI.getLogger().log(Level.SEVERE, "Error in plugin YouGuilds!", ex);
            this.getServer().getPluginManager().disablePlugin(this);
        }
        this.database = Database.createSQLite(file);

        YouAPI.getUserManager().loadAll();
    }

    @Override
    public void onDisable()
    {
        if (!status)
        {
            return;
        }
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
    public Database getDB()
    {
        return this.database;
    }

    @Override
    public UserManager getUserManager()
    {
        return this.userManager;
    }
}
