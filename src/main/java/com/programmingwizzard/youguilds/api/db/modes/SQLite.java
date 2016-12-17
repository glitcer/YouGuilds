package com.programmingwizzard.youguilds.api.db.modes;

import com.programmingwizzard.youguilds.api.db.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public class SQLite extends Database
{
    private final File file;

    public SQLite(File file)
    {
        this.file = file;
    }

    @Override
    protected Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
    }
}
