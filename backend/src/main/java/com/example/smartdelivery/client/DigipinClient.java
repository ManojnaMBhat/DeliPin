package com.example.smartdelivery.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class DigipinClient {

	    private final RestTemplate restTemplate;

	    @Value("${digipin.api.url}")   // e.g., http://localhost:5000/api/digipin
	    private String digipinApiUrl;

	    public DigipinClient() {
	        this.restTemplate = new RestTemplate();
	    }

	    public Map<String, Object> decodePin(String pin) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        Map<String, String> requestBody = Map.of("digipin", pin);
	        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

	        ResponseEntity<Map> response = restTemplate.postForEntity(
	                digipinApiUrl + "/digipin/decode",
	                request,
	                Map.class
	        );

	        return response.getBody();
	    }
}




    


