package com.adobe.devcamp.controller;


import com.adobe.devcamp.ResourceNotFoundException;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.service.AdvertisingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertiserController {


    private final AdvertisingService<Campaign> campaignService;

    public AdvertiserController(AdvertisingService<Campaign> campaignService)
    {
        this.campaignService = campaignService;
    }

    @GetMapping(path="/campaigns/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    private Campaign getCampaignById(@PathVariable("id") Integer id) throws ResourceNotFoundException
    {
     Campaign campaign = campaignService.selectById(Campaign.class, id);
     if(campaign==null)
     {
         throw new ResourceNotFoundException(id.toString());
     }
     return campaign;
    }
}
