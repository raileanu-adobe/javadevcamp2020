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

package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.AdvertisingDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdvertisingService<T> {
    private static final Logger logger = LoggerFactory.getLogger(AdvertisingService.class);
    private final AdvertisingDao<T> advertisingDao;
    private final ObjectMapper objectMapper;

    public AdvertisingService(AdvertisingDao<T> advertisingDao, ObjectMapper objectMapper) {
        this.advertisingDao = advertisingDao;
        this.objectMapper = objectMapper;
    }

    //select users from db and convert
    //Map<Integer, String> into Map<Integer, T>
    public Map<Integer, T> selectAll(Class<T> clazz){
        final Map<Integer, String> allAsString = advertisingDao.selectAll(clazz);
        final Map<Integer, T> all = new HashMap<>();

        for(Map.Entry<Integer, String> entry: allAsString.entrySet()){
            try {
                final T t = objectMapper.readValue(entry.getValue(), clazz);
                all.put(entry.getKey(), t);
            } catch (JsonProcessingException e) {
                logger.error("Object {} couldn't be deserialized", entry.getValue(), e);
            }
        }

        return all;
    }

    public T selectById(Class<T> clazz, int id) {
        final String json = advertisingDao.selectById(clazz, id);
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            logger.error("Object {} couldn't be read", json);
        }
        return null;
    }
}
