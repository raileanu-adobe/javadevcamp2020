package com.adobe.devcamp.dao;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UserDao { //for db connection

    private final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection;

    private static final Map<Class, String> TABLES = new HashMap<>();
    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Publisher.class, "publishers");
        TABLES.put(Campaign.class, "campaigns");
    }

    public UserDao (DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public Map<Integer, String> selectAll() {
        Map<Integer, String> all = new HashMap<>();

       final String query = "SELECT * FROM " + TABLES.get(User.class);

        final Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.put(resultSet.getInt(1), resultSet.getString(2)); //1 -> id 2 -> json
            }
        } catch (SQLException e) {
            logger.error("Query {} failed because {}", query, e.getMessage());
            //Nu e nevoie de return deoarece deja am instantiat all ca o mapa goala
        }

        return all;
    }
}
