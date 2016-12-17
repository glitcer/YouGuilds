package com.programmingwizzard.youguilds.api.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public interface DatabaseCallback
{
    void call(ResultSet resultSet) throws SQLException;
}
