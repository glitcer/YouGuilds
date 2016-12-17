package com.programmingwizzard.youguilds.api.db;

import com.programmingwizzard.youguilds.api.YouAPI;
import com.programmingwizzard.youguilds.api.db.modes.SQLite;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/*
 * @author ProgrammingWizzard
 * @date 2016-12-17
 */
public abstract class Database extends Thread
{
    public static Database createSQLite(File file)
    {
        if (file == null)
        {
            throw new NullPointerException("File can not be null!");
        }
        return new SQLite(file);
    }

    protected abstract Connection getConnection() throws SQLException;

    public void update(String query)
    {
        if (query == null || query.isEmpty())
        {
            throw new NullPointerException("Query can not be null!");
        }
        YouAPI.runAsync(() ->
        {
            try
            {
                Connection connection = this.getConnection();
                if (connection == null || connection.isClosed())
                {
                    throw new SQLException("Connection has not been opened!");
                }
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();
                statement.close();
            }
            catch (SQLException ex)
            {
                YouAPI.getLogger().log(Level.SEVERE, "Error in plugin YouGuilds", ex);
            }
        });
    }

    public void query(String query, DatabaseCallback callback)
    {
        if (query == null || query.isEmpty())
        {
            throw new NullPointerException("Query or Callback can not be null!");
        }
        YouAPI.runAsync(() ->
        {
            try
            {
                Connection connection = this.getConnection();
                if (connection == null || connection.isClosed())
                {
                    throw new SQLException("Connection has not been opened!");
                }
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                callback.call(result);
                result.close();
                statement.close();
            }
            catch (SQLException ex)
            {
                YouAPI.getLogger().log(Level.SEVERE, "Error in plugin YouGuilds", ex);
            }
        });
    }
}
