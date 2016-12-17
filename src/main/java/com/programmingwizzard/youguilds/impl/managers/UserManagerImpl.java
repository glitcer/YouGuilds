package com.programmingwizzard.youguilds.impl.managers;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.programmingwizzard.youguilds.api.basic.User;
import com.programmingwizzard.youguilds.api.managers.UserManager;
import com.programmingwizzard.youguilds.impl.basic.UserImpl;

import java.util.Collection;
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
    public void createNewUser(UUID uuid)
    {
        if (this.get(uuid) != null)
        {
            return;
        }
        User user = new UserImpl(uuid);
        userMap.put(uuid, user);
        userCache.put(uuid, user);
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
    public Collection<User> getTop(int number)
    {
        // TODO
        return null;
    }
}
