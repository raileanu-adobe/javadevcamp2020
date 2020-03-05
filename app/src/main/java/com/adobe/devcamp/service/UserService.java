package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.UserDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//Contine cazurile de utilizare/ business logic

//Spring helps to create objects of this kind
//Spring Boot is faster than Spring framework
@Service
public class UserService {
    final static Logger logger = LoggerFactory.getLogger(UserService.class);
    final UserDao userDao;
    final ObjectMapper objectMapper;

    /*
        Dependency injection
        The object is created outside
     */
    public UserService(UserDao userDao, ObjectMapper objectMapper) {
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    /*
        Select users  from db and convert Map<Integer, String>
        in Map<Integer, User>
     */
    public Map<Integer, User> selectAll() {
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for (Map.Entry<Integer, String> entry : usersAsString.entrySet()) {
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} could not be deserialized", entry.getValue());
            }
        }
        return users;
    }
}
