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

//punem bin-ul in context
@Service //adnotare
public class UserService {
    final UserDao userDao; //dependay injection
    //am nevoie de un userDao, nu il creez aici il primesc din afara
    final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDao userDao,  ObjectMapper objectMapper) {
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    //select users from db Map<Integer, String> -> Map<Integer,User>
    public Map<Integer, User> selectAll(){
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for(Map.Entry<Integer, String> entry: usersAsString.entrySet()) {
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} caouldn't be deserialized", entry.getValue());
            }
        }

        return users;
    }

}
