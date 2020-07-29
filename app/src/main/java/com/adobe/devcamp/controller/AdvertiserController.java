package com.adobe.devcamp.controller;

import com.adobe.devcamp.ResourceNotFoundException;
import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.AdvertisingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdvertiserController {
    private final AdvertisingService<Campaign> campaignService;
    private final AdvertisingService<Advertiser> advertisingService;
    private final AdvertisingService<Publisher> publisherService;
    private final AdvertisingService<User> userService;

    public AdvertiserController(AdvertisingService<Campaign> campaignService,
                                AdvertisingService<Advertiser> advertisingService,
                                AdvertisingService<Publisher> publisherService,
                                AdvertisingService<User> userService) {
        this.campaignService = campaignService;
        this.advertisingService = advertisingService;
        this.publisherService = publisherService;
        this.userService = userService;
    }

    @GetMapping(path = "/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private Campaign getCampaignById(@PathVariable(name = "id") Integer id)
            throws ResourceNotFoundException {
        Campaign campaign = campaignService.selectById(Campaign.class, id);
        if (campaign == null) {
            throw new ResourceNotFoundException(id.toString());
        }
        return campaign;
    }

    @GetMapping(path = "/publishers", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Publisher> getPublishers(@RequestParam(name = "advertiserId") Integer advertiserId) {
        Advertiser advertiser = advertisingService.selectById(Advertiser.class, advertiserId);
        return advertiser.getPublishers().stream()
                .map(publisherId -> publisherService.selectById(Publisher.class, publisherId))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/advertisers/users", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<User> getTargetedUsers(@RequestParam(name = "advertiserId") Integer advertiserId,
                                        @RequestParam(name = "campaignId") Integer campaignId) {
        Advertiser advertiser = advertisingService.selectById(Advertiser.class, advertiserId);
        Campaign campaign = campaignService.selectById(Campaign.class, campaignId);
        List<Publisher> publishers = this.getPublishers(advertiserId);
        return publishers.stream()
                //.map(publisher -> getTargetedUsersForPublisher(publisher, campaign))
                //.flatMap(Collection::stream)
                .flatMap(publisher -> getTargetedUsersForPublisher(publisher, campaign).stream())
                .collect(Collectors.toList());
    }

    public List<User> getTargetedUsersForPublisher(Publisher publisher, Campaign campaign) {
        List<User> users = publisher.getUsers().stream()
                                .map(userId -> userService.selectById(User.class, userId))
                                .collect(Collectors.toList());
        return users.stream()
                .filter(user -> user.getProfile().getGender().equals(campaign.getTarget().getGender()))
                .filter(user -> user.getProfile().getInterests().equals(campaign.getTarget().getInterests()))
                .collect(Collectors.toList());
    }
}
