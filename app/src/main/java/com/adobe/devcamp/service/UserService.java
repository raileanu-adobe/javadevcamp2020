package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.UserDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserService {

    private final UserDao userDao;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDao userDao, UserDao userDao1, ObjectMapper objectMapper) {
        this.userDao = userDao1;
        this.objectMapper = objectMapper;
    }

    //select user from db and convert Map<Integer,String in Map<Integer,User>
    public Map<Integer, User> selectAll() throws SQLException {
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for (Map.Entry<Integer, String> entry : usersAsString.entrySet()) {
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} couldnt be deseialize ", entry.getValue());
            }
        }
    return users;
    }
}
