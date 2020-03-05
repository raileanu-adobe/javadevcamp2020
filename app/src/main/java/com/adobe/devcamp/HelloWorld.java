package com.adobe.devcamp;

import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class HelloWorld {
    //we will use a framework( SpringBoot)
    //to create userService( inversion of controlling)
    private static UserService userService;

    public HelloWorld(UserService userService) {
        HelloWorld.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class);
        System.out.println("Hello World");
        final Map<Integer, User> users = userService.selectAll();
        users.entrySet()
                .forEach(entry-> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
