package com.programmingwizzard.youguilds.api;

import com.programmingwizzard.youguilds.api.managers.UserManager;

import java.util.logging.Logger;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class YouAPI
{
    private static API api;

    public static void setAPI(API api) throws IllegalAccessException
    {
        if (YouAPI.api != null)
        {
            throw new IllegalAccessException("API is not null");
        }
        YouAPI.api = api;
    }

    public static void runAsync(Runnable runnable)
    {
        if (runnable == null)
        {
            throw new NullPointerException("Runnable can not be null");
        }
        YouAPI.api.runAsync(runnable);
    }

    public static void runAsyncTimer(Runnable runnable, long period)
    {
        if (runnable == null)
        {
            throw new NullPointerException("Runnable can not be null!");
        }
        YouAPI.api.runAsyncTimer(runnable, period);
    }

    public static Logger getLogger()
    {
        return YouAPI.api.getLogger();
    }

    public static UserManager getUserManager()
    {
        return YouAPI.api.getUserManager();
    }
}
