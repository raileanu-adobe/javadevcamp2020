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

//annotation for SpringBoot
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao;
    private final ObjectMapper objectMapper;

    //dependency injection
    public UserService(UserDao userDao, ObjectMapper objectMapper) {
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    //select users from database
    //convert Map<Integer, String> into Map<Integer, User>
    public Map<Integer, User> selectAll() {
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for (Map.Entry<Integer, String> entry : usersAsString.entrySet()) {
            try {
                //deserialization String into User
               final User user =  objectMapper.readValue(entry.getValue(), User.class);
               users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} couldn't be deserialized", entry.getValue());
            }
        }
        return users;
    }
}
