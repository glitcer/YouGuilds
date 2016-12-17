package com.programmingwizzard.youguilds.impl.basic;

import com.programmingwizzard.youguilds.api.basic.Rank;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class RankImpl implements Rank
{
    private int rank;
    private int kills;
    private int deaths;

    public RankImpl(int rank, int kills, int deaths)
    {
        this.rank = rank;
        this.kills = kills;
        this.deaths = deaths;
    }

    public RankImpl()
    {
        this(1000, 0, 0);
    }

    @Override
    public int getRank()
    {
        return rank;
    }

    @Override
    public int getKills()
    {
        return kills;
    }

    @Override
    public int getDeaths()
    {
        return deaths;
    }

    @Override
    public void setRank(int rank)
    {
        this.rank = rank;
    }

    @Override
    public void setKills(int kills)
    {
        this.kills = kills;
    }

    @Override
    public void setDeaths(int deaths)
    {
        this.deaths = deaths;
    }
}
