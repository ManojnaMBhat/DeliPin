package com.example.smartdelivery.service;

import com.example.smartdelivery.client.OSMClient;
import com.example.smartdelivery.model.*;
import com.example.smartdelivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RouteService {
	

	 @Autowired
	    private OSMClient osmClient;

	    @Autowired
	    private DeliveryRepository deliveryRepository;

	    /**
	     * Compute optimized route starting from 'start', visiting all deliveries.
	     * Uses OSRM distances and durations from OSMClient.
	     * Returns a RouteResponse with total distance, duration, and path.
	     */
	    public RouteResponse computeRoute(Location start, List<Delivery> deliveries) {
	        List<Location> path = new ArrayList<>();
	        double totalDistance = 0;
	        long totalDuration = 0;

	        Location current = start;
	        List<Delivery> remaining = new ArrayList<>(deliveries);

	        while (!remaining.isEmpty()) {
	            Delivery nearest = null;
	            double bestDist = Double.MAX_VALUE;
	            long bestDuration = 0;

	            // Find nearest pickup from current location
	            for (Delivery d : remaining) {
	                Location pickupLoc = new Location(d.getPickupLat(), d.getPickupLng());
	                Map<String, Object> res = osmClient.estimate(current, pickupLoc);
	                double dist = ((Number) res.getOrDefault("distance", 0)).doubleValue();
	                long dur = ((Number) res.getOrDefault("duration", 0)).longValue();

	                if (dist < bestDist) {
	                    bestDist = dist;
	                    bestDuration = dur;
	                    nearest = d;
	                }
	            }

	            if (nearest == null) break;

	            // Move to pickup
	            Location pickupLoc = new Location(nearest.getPickupLat(), nearest.getPickupLng());
	            path.add(pickupLoc);
	            totalDistance += bestDist;
	            totalDuration += bestDuration;

	            // Move to delivery/drop
	            Location dropLoc = new Location(nearest.getDropLat(), nearest.getDropLng());
	            Map<String, Object> dropRes = osmClient.estimate(pickupLoc, dropLoc);
	            double dropDist = ((Number) dropRes.getOrDefault("distance", 0)).doubleValue();
	            long dropDur = ((Number) dropRes.getOrDefault("duration", 0)).longValue();

	            path.add(dropLoc);
	            totalDistance += dropDist;
	            totalDuration += dropDur;

	            // Update current location and remove this delivery from remaining
	            current = dropLoc;
	            remaining.remove(nearest);
	        }

	        return new RouteResponse(totalDistance, totalDuration, path);
	    }
}
