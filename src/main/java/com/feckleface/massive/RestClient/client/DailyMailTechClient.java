package com.feckleface.massive.RestClient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class DailyMailTechClient {

    @Autowired
    private RestOperations restOperations;

    public ResponseEntity getFromDailyMail() {

        ResponseEntity result = restOperations.getForEntity("https://secured.dailymail.co.uk/feeds/commercial/topVideos.json", Object.class);

        return result;
    }

}
