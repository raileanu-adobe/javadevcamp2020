package com.adobe.devcamp.DAO;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//peste dao vine layeru-ul de service -> cazurile de utilizare

@Repository
public class UserDao {

    private final Connection connection;
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private static final Map<Class, String> TABLES = new HashMap<>();

    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Campaign.class, "campaigns");
        TABLES.put(Publisher.class, "publishers");
    }

    public UserDao(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public Map<Integer, String> selectAll() {
        Map<Integer, String> all = new HashMap<>();

        final String query = "SELECT * FROM " + TABLES.get(User.class);

        try{
            final Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                all.put(result.getInt(1), result.getString(2));
            }
        }catch (SQLException e){
            logger.error("Query {} faild because {} ", query, e.getMessage());
        }

        return all;
    }
}