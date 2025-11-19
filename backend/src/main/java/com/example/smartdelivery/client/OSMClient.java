package com.example.smartdelivery.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.smartdelivery.model.Location;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class OSMClient {
	
	@Value("${osrm.api.url}") // e.g., http://router.project-osrm.org/route/v1/driving/
    private String osrmBaseUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public OSMClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Get distance (meters) and duration (seconds) between two locations using OSRM.
     */
    public Map<String, Object> estimate(Location origin, Location destination) {
        Map<String, Object> result = new HashMap<>();
        try {
            // OSRM URL format: /{profile}/{lon1},{lat1};{lon2},{lat2}?overview=false
            String url = String.format("%s%f,%f;%f,%f?overview=false",
                    osrmBaseUrl,
                    origin.getLng(), origin.getLat(),
                    destination.getLng(), destination.getLat());

            String response = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(response);

            if (root.has("routes") && root.get("routes").isArray() && root.get("routes").size() > 0) {
                JsonNode route = root.get("routes").get(0);
                double distance = route.get("distance").asDouble(); // in meters
                long duration = route.get("duration").asLong();     // in seconds
                result.put("distance", distance);
                result.put("duration", duration);
            } else {
                // fallback if OSRM fails
                result.put("distance", 0);
                result.put("duration", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("distance", 0);
            result.put("duration", 0);
        }

        return result;
    }
}
