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
// prin asta ii spun Spring-ului sa creeze un obiect de genul asta
// folosim SpringBoot(e mai rapid decat spring framework, nu cere prea multa configurare)

public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao; // dependency injection
    private final ObjectMapper objectMapper;

    public UserService(UserDao userDao, ObjectMapper objectMapper){
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    // Select users from db
    // and convert from Map<Integer, String> to Map<Integer, User>
    // aka deserializes the objects
    public Map<Integer, User> selectAll(){
        final Map<Integer, String> usersAsString = userDao.selectAll();
        final Map<Integer, User> users = new HashMap<>();

        for(Map.Entry<Integer, String> entry : usersAsString.entrySet()){
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
