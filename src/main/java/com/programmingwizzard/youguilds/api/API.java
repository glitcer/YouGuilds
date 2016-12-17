package com.programmingwizzard.youguilds.api;

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

    UserManager getUserManager();

    Logger getLogger();
}
