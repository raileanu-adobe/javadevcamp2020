package com.adobe.devcamp;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.AdvertisingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class HelloWorld {

    private static AdvertisingService<User> userService;
    private static AdvertisingService<Publisher> publisherService;
    private static AdvertisingService<Advertiser> advertiserService;
    private static AdvertisingService<Campaign> campaignService;

    public HelloWorld(AdvertisingService userService,
                      AdvertisingService publisherService,
                      AdvertisingService advertiserService,
                      AdvertisingService campaignService,
                      ObjectMapper objectMapper) {
        HelloWorld.userService = userService;
        HelloWorld.publisherService = publisherService;
        HelloWorld.advertiserService = advertiserService;
        HelloWorld.campaignService = campaignService;
        HelloWorld.objectMapper = objectMapper;
    }

    private static ObjectMapper objectMapper;

    public static void main(String[] args) throws Exception{
        SpringApplication.run(HelloWorld.class);
        System.out.println("Select all users");
        final Map<Integer, User> users = userService.selectAll(User.class);
        users.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nSelect by Id");
        User user = userService.selectById(User.class, 1);
        System.out.println(objectMapper.writeValueAsString(user));

        System.out.println("\nSelect all publishers");
        final Map<Integer, Publisher> publishers = publisherService.selectAll(Publisher.class);
        publishers.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nSelect all advertisers");
        final Map<Integer, Advertiser> advertisers = advertiserService.selectAll(Advertiser.class);
        advertisers.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nSelect all campaigns");
        final Map<Integer, Campaign> campaigns = campaignService.selectAll(Campaign.class);
        campaigns.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));
    }


}