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

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao;
    private final ObjectMapper objectMapper;

    public UserService(UserDao userDao, ObjectMapper objectMapper) {
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    //select users from databse and convert json info to user object
    public Map<Integer, User> selectAll(){
        final Map<Integer, String> usersAsStrings = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for(Map.Entry<Integer, String> entry: usersAsStrings.entrySet()){
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} couldn't be deserialized", entry.getValue());
            }
        }

        return users;
    }
}
