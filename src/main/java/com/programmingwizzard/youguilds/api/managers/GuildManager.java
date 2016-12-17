package com.programmingwizzard.youguilds.api.managers;

import com.programmingwizzard.youguilds.api.basic.Guild;
import com.programmingwizzard.youguilds.api.basic.User;

import java.util.Collection;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface GuildManager
{
    Guild get(String tag);

    Guild createNewGuild(String tag, String name, User leader);

    void loadAll();

    void saveAll();

    Collection<Guild> get(int number);
}
