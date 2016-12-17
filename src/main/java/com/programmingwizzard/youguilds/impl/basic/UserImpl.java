package com.programmingwizzard.youguilds.impl.basic;

import com.programmingwizzard.youguilds.api.basic.User;

import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class UserImpl implements User
{
    private final UUID uuid;

    public UserImpl(UUID uuid)
    {
        this.uuid = uuid;
    }

    @Override
    public UUID getUUID()
    {
        return this.uuid;
    }
}
