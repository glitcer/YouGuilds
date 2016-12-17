package com.programmingwizzard.youguilds.impl.basic;

import com.programmingwizzard.youguilds.api.basic.Rank;
import com.programmingwizzard.youguilds.api.basic.User;

import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class UserImpl implements User
{
    private final UUID uuid;
    private final Rank rank;

    public UserImpl(UUID uuid)
    {
        this.uuid = uuid;
        this.rank = new RankImpl();
    }

    public UserImpl(UUID uuid, int rank, int kills, int deaths)
    {
        this.uuid = uuid;
        this.rank = new RankImpl(rank, kills, deaths);
    }

    @Override
    public UUID getUUID()
    {
        return this.uuid;
    }

    @Override
    public Rank getRank()
    {
        return this.rank;
    }
}
