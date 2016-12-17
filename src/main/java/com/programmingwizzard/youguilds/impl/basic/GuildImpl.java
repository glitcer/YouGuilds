package com.programmingwizzard.youguilds.impl.basic;

import com.programmingwizzard.youguilds.api.basic.Guild;
import com.programmingwizzard.youguilds.api.basic.Rank;
import com.programmingwizzard.youguilds.api.basic.User;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class GuildImpl implements Guild
{
    private final String tag;
    private final String name;
    // TODO
    private final List<User> users = new ArrayList<>(30);
    private final Rank rank = new RankImpl();

    private User leader;

    public GuildImpl(String tag, String name, User leader)
    {
        this.tag = tag;
        this.name = name;
        this.leader = leader;
    }

    @Override
    public String getTag()
    {
        return this.tag;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public User getLeader()
    {
        return this.leader;
    }

    @Override
    public List<User> getUsers()
    {
        return this.users;
    }

    @Override
    public Location getHomeLocation()
    {
        // TODO
        return null;
    }

    @Override
    public Rank getRank()
    {
        return this.rank;
    }

    @Override
    public int getCuboidSize()
    {
        // TODO
        return 100;
    }

    @Override
    public void setLeader(User leader)
    {
        this.leader = leader;
    }

    @Override
    public void calcRank()
    {
        int usersSize = this.getUsers().size();
        int rank = 0;
        int kills = 0;
        int deaths = 0;
        for (User user : this.users)
        {
            rank = rank + user.getRank().getRank();
            kills = kills + user.getRank().getKills();
            deaths = deaths +  user.getRank().getDeaths();
        }
        rank = rank / usersSize;
        this.rank.setRank(rank);
        this.rank.setKills(kills);
        this.rank.setDeaths(deaths);
    }

    @Override
    public void delete()
    {

    }
}
