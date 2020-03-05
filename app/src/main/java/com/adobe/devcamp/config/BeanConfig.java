package com.adobe.devcamp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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

    @Bean //for Spring to create the objects
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    /*
    If we not use SpringBoot
    BeanConfig config = new BeanConfig();
    DataSource ds = new DataSource();
     */
}
