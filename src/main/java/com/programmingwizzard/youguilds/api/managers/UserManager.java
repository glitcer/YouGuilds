package com.programmingwizzard.youguilds.api.managers;

import com.programmingwizzard.youguilds.api.basic.User;

import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface UserManager
{
    User get(UUID uuid);

    void loadAll();

    void saveAll();
}
