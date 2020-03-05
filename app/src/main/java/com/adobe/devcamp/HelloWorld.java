package com.adobe.devcamp;

import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Map;

@SpringBootApplication
public class HelloWorld {

    private static UserService userService ; // null ptr expection - dar ne complicam daca il declaram aici
    //trebuie sa facem un userDao, objectMapper
    // folosim inversion of control ceva -> prin adnotari
    // adnotari -> punem niste conditii


    public HelloWorld(UserService userService) {
        HelloWorld.userService = userService;
    }

    public static void main(String[] args) {

        SpringApplication.run(HelloWorld.class);
        System.out.println("Hello World");

        final Map<Integer, User> users = userService.selectAll();
        users.entrySet().forEach(entry -> System.out.println(entry.getKey() + "-" +  entry.getValue()));
    }
}
