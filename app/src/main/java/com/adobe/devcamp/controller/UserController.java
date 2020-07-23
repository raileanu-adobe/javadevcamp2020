package com.adobe.devcamp.controller;

import com.adobe.devcamp.model.Gender;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.AdvertisingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final AdvertisingService<User> userService;

    public UserController(AdvertisingService<User> userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<User> getAllUsers() {
        return new ArrayList<>(userService.selectAll(User.class).values());
    }

    @GetMapping(path = "/users", params = "gender",
                produces = MediaType.APPLICATION_JSON_VALUE)
    private List<User> getUsersByGender(@RequestParam(name = "gender") String gender) {
        ArrayList<User> users = new ArrayList<>(userService.selectAll(User.class).values());
        ArrayList<User> userByGender = new ArrayList<>();
        for (User user : users) {
            if (user.getProfile().getGender() == Gender.valueOf(gender)) {
                userByGender.add(user);
            }
        }
        return userByGender;
    }
}
