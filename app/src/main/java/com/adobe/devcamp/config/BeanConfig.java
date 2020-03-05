package com.adobe.devcamp.config;

import com.adobe.devcamp.dao.UserDao;
import com.adobe.devcamp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class BeanConfig {

    @Bean
    public DataSource dataSource() {
        final MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/javadevcamp");
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public UserDao userDao(DataSource dataSource) throws SQLException {
        return new UserDao(dataSource);
    }

    @Bean
    public UserService userService(UserDao userDao, ObjectMapper objectMapper) throws SQLException {
        return new UserService(userDao, objectMapper);
    }


}
