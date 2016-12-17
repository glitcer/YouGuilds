package com.programmingwizzard.youguilds.api.managers;

import com.programmingwizzard.youguilds.api.basic.User;

import java.util.Collection;
import java.util.UUID;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface UserManager
{
    User get(UUID uuid);

    void createNewUser(UUID uuid);

    void loadAll();

    void saveAll();

    Collection<User> getTop(int number);
}
