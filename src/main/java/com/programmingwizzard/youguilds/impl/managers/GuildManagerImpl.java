package com.programmingwizzard.youguilds.impl.managers;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.programmingwizzard.youguilds.api.basic.Guild;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.api.managers.GuildManager;
import com.programmingwizzard.youguilds.impl.basic.GuildImpl;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class GuildManagerImpl implements GuildManager
{
    private final Map<String, Guild> guildMap = new ConcurrentHashMap<>();
    private final Cache<String, Guild> guildCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

    @Override
    public Guild get(String tag)
    {
        Guild guild = guildCache.getIfPresent(tag);
        if (guild == null)
        {
            guild = guildMap.get(tag);
            if (guild == null)
            {
                return null;
            }
            guildCache.put(tag, guild);
        }
        return guild;
    }

    @Override
    public Guild createNewGuild(String tag, String name, User leader)
    {
        if (tag == null || name == null || tag.isEmpty() || name.isEmpty())
        {
            throw new NullPointerException("Tag or Name can not be null");
        }
        if (this.get(tag) != null)
        {
            return null;
        }
        Guild guild = new GuildImpl(tag, name, leader);
        guildMap.put(tag, guild);
        guildCache.put(tag, guild);
        return guild;
    }

    @Override
    public void loadAll()
    {

    }

    @Override
    public void saveAll()
    {

    }

    @Override
    public Collection<Guild> get(int number)
    {
        return null;
    }
}
