package com.programmingwizzard.youguilds.api.basic;

import org.bukkit.Location;

import java.util.List;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface Guild
{
    String getTag();

    String getName();

    User getLeader();

    List<User> getUsers();

    Location getHomeLocation();

    Rank getRank();

    int getCuboidSize();

    void setLeader(User leader);

    void calcRank();

    void delete();
}
