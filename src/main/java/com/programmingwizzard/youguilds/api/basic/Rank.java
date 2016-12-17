package com.programmingwizzard.youguilds.api.basic;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface Rank
{
    int getRank();

    int getKills();

    int getDeaths();

    void setRank(int rank);

    void setKills(int kills);

    void setDeaths(int deaths);
}
