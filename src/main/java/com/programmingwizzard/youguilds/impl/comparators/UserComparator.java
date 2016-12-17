package com.programmingwizzard.youguilds.impl.comparators;

import com.programmingwizzard.youguilds.api.basic.User;

import java.util.Comparator;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class UserComparator implements Comparator<User>
{
    @Override
    public int compare(User o1, User o2)
    {
        Integer r1 = o1.getRank().getRank();
        Integer r2 = o2.getRank().getRank();
        return r2.compareTo(r1);
    }
}
