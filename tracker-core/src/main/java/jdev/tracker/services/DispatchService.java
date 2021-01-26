package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DispatchService {

    private static final Logger log = LoggerFactory.getLogger(DispatchService.class);
    private static final String uri = "http://localhost:8080/upload";

    private StoreService storeService;
    private RestTemplate restTemplate;

    public DispatchService(@Autowired StoreService storeService,
                           @Autowired RestTemplate restTemplate) {
        this.storeService = storeService;
        this.restTemplate = restTemplate;
    }

//    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRateString = "${sendingPeriod.prop}",
            initialDelayString = "${initialDelay.prop}")
    private void send() throws InterruptedException, JsonProcessingException {
        post(storeService.takeAll());
    }

    public TrackDTO post(ArrayList<PointDTO> points) throws JsonProcessingException {

        if (!points.isEmpty()) {
            log.info("___Dispatching " + points.size() + " track points:");

            HttpHeaders headers = new HttpHeaders();
            TrackDTO td = new TrackDTO(points);
            HttpEntity<TrackDTO> requestEntity = new HttpEntity<>(td, headers);

            TrackDTO response = restTemplate.postForObject(uri, td, TrackDTO.class);
//            restTemplate.postForObject(uri, requestEntity, String.class);
//            restTemplate.postForLocation(uri, td);
//            restTemplate.postForLocation(uri, requestEntity);
//            restTemplate.postForEntity(uri, td, String.class);
//            restTemplate.postForEntity(uri, requestEntity, String.class);
//            restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
//            ResponseEntity<TrackDTO> response =
//                    restTemplate.exchange(uri, HttpMethod.POST, requestEntity, TrackDTO.class);

//            log.info(response.getBody().toJson());
            if (response != null)
                log.info(response.toJson());

            extractJsonPoints(points).forEach(log::info)            ;
            return response;
        }
        return null;
    }

        private List<String> extractJsonPoints(ArrayList<PointDTO> points) throws JsonProcessingException {
            List<String> pointList = new ArrayList<>();
            for (PointDTO p: points)
                pointList.add(p.toJson());
            return pointList;
        }
    }