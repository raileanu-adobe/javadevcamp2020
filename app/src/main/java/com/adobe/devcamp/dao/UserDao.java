package com.adobe.devcamp.dao;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    // static - same for all instances
    private static final Map<Class, String> TABLES = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);

    // send queries and receive data
    private final Connection connection;

    public UserDao(DataSource dataSource) throws SQLException {
        // try catch: handle error here, throws: handle error in the method calling this method
        this.connection = dataSource.getConnection();
    }

    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Campaign.class, "campaigns");
        TABLES.put(Publisher.class, "publishers");
    }

    public Map<Integer, String> selectAll() {
        Map<Integer, String> all = new HashMap<>();

        final String query = "SELECT * FROM " + TABLES.get(User.class);
        try {
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.put(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch(SQLException ex) {
            logger.error("Query {} failed because {}", query, ex.getMessage());
        }
        return all;
    }
}
