/*
 ************************************************************************
  * ADOBE CONFIDENTIAL
  * ___________________
  *
  * Copyright 2018 Adobe Systems Incorporated
  * All Rights Reserved.
  *
  * NOTICE:  All information contained herein is, and remains
  * the property of Adobe Systems Incorporated and its suppliers,
  * if any.  The intellectual and technical concepts contained
  * herein are proprietary to Adobe Systems Incorporated and its
  * suppliers and are protected by all applicable intellectual property laws,
  * including trade secret and copyright laws.
  * Dissemination of this information or reproduction of this material
  * is strictly forbidden unless prior written permission is obtained
  * from Adobe Systems Incorporated.
  ***********************************************************************
 */

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
    private static AdvertisingService<Advertiser> advertisingService;
    private static AdvertisingService<Campaign> campaignService;

    private static ObjectMapper objectMapper;

    public HelloWorld(AdvertisingService<User> userService,
                      AdvertisingService<Publisher> publisherService,
                      AdvertisingService<Advertiser> advertisingService,
                      AdvertisingService<Campaign> campaignService,
                      ObjectMapper objectMapper) {
        HelloWorld.userService = userService;
        HelloWorld.publisherService = publisherService;
        HelloWorld.advertisingService = advertisingService;
        HelloWorld.campaignService = campaignService;
        HelloWorld.objectMapper = objectMapper;
    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(HelloWorld.class);
        System.out.println("\nHello World");
        final Map<Integer, User> users = userService.selectAll(User.class);
        users.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nUser with id: 1");
        User user = userService.selectById(User.class, 1);
        System.out.println(objectMapper.writeValueAsString(user));

        System.out.println("\nPublishers");
        final Map<Integer, Publisher> publishers = publisherService.selectAll(Publisher.class);
        publishers.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nAdvertisers");
        final Map<Integer, Advertiser> advertisers = advertisingService.selectAll(Advertiser.class);
        advertisers.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));

        System.out.println("\nCampaigns");
        final Map<Integer, Campaign> campaigns = campaignService.selectAll(Campaign.class);
        campaigns.entrySet().forEach(entry->System.out.println(entry.getKey()+"-"+entry.getValue()));
    }

}
