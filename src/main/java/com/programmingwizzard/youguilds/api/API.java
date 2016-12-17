package com.programmingwizzard.youguilds.api;

import com.programmingwizzard.youguilds.api.db.Database;
import com.programmingwizzard.youguilds.api.managers.GuildManager;
import com.programmingwizzard.youguilds.api.managers.UserManager;

import java.util.logging.Logger;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface API
{
    void runAsync(Runnable runnable);

    void runAsyncTimer(Runnable runnable, long period);

    Database getDB();

    UserManager getUserManager();

    GuildManager getGuildManager();

    Logger getLogger();
}
