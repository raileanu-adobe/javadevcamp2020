package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.UserDAO;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service //-> Spring Boot
public class UserService {
    //dependencies
    static final Logger logger = LoggerFactory.getLogger(UserService.class);
    final UserDAO userDao;
    final ObjectMapper objectMapper;

    public UserService(UserDAO userDao, ObjectMapper objectMapper) { // dependency injection
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    //select users from database + convert Map<Integer, String> into Map<Integer, User>
    public Map<Integer, User> selectAll(){
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for(Map.Entry<Integer, String> entry: usersAsString.entrySet()){
            try {
                final User user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            }catch (JsonProcessingException e){
                logger.error("Object {} couldn't be deserialized", entry.getValue());
            }
        }

        return users;
    }
}
