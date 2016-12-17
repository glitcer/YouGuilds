package com.programmingwizzard.youguilds.impl.managers;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.api.managers.UserManager;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class UserManagerImpl implements UserManager
{
    private final Map<UUID, User> userMap = new ConcurrentHashMap<>();
    private final Cache<UUID, User> userCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

    @Override
    public User get(UUID uuid)
    {
        User user = this.userCache.getIfPresent(uuid);
        if (user == null)
        {
            user = this.userMap.get(uuid);
            if (user == null)
            {
                return null;
            }
            this.userCache.put(uuid, user);
        }
        return user;
    }

    @Override
    public void loadAll()
    {
        // TODO
    }

    @Override
    public void saveAll()
    {
        // TODO
    }
}
