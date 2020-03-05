package com.adobe.devcamp.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanConfig  {

    @Bean
    public DataSource dataSource() {
        final MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/javadevcamp");
        dataSource.setUser("root");
        dataSource.setPassword("");

        return dataSource; //se ocupa de conexiunea la baza de date
        //prin dataSource facem operatiile din userDao
    }

    @Bean //creaza si pune in context
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    //daca le faceam noi -> trebuia initializata clasa si sa facem noi datasource si mapper
}
