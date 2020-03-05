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

        // jdbc = mysql protocol
        dataSource.setUrl("jdbc:mysql://localhost:3306/javadevcamp");

        // credentials from nosql.sql script
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
    }

    /*
    BeanConfig bean = new BeanConfig();
    DataSource ds = bean.dataSource();
    with ds -> operations in dao (crud operations)
     */

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
