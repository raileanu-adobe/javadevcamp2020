package com.adobe.devcamp.service;

import com.adobe.devcamp.DAO.UserDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//pune bean ul in context -> create a bean si il punem in contact cu altele
// SpringBoot -> ne permite sa realizam apps mai rapid, fara prea multa configurare
// spring io initializer

@Service
public class UserService {
    static final Logger loggegr = LoggerFactory.getLogger(UserService.class);
    final UserDao userDao;
    final ObjectMapper objectMapper;

    public UserService(UserDao userDao, ObjectMapper objectMapper) {  // dependency injection -> pt a crea un obj user service am nevoie
        //ca un alt userDao sa fie creat inainte, dao e injectat (nu il creez aici, am o dependinta de UserDAO primit din afara)

        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    // primul use case -> select users from database and convert map<integer, string> in map<integer, user>
    public Map<Integer, User> selectAll() {

        final Map<Integer, String> usersAsStrings = userDao.selectAll();
        final Map<Integer, User> users= new HashMap<>();

        for(Map.Entry<Integer,String> entry :  usersAsStrings.entrySet()){

            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);

                users.put(entry.getKey(), user);

            } catch (JsonProcessingException e) {
                // nu e ok sa aratam stack ul de metode
                loggegr.error("Object {} couldn't be deserialized", entry.getValue());
            }
        }

        return users;
    }
}
