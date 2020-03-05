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
        //jdbc = protocol mysql
        dataSource.setURL("jdbc:mysql://localhost:3306/javadevcamp");
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

