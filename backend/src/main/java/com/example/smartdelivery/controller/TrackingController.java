package com.example.smartdelivery.controller;

import com.example.smartdelivery.model.TrackingUpdate;
import com.example.smartdelivery.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping("/update")
    public TrackingUpdate update(@RequestBody TrackingUpdate update) {
        return trackingService.saveUpdate(update);
    }

    @GetMapping("/{deliveryId}")
    public List<TrackingUpdate> get(@PathVariable Long deliveryId) {
        return trackingService.getTrackingForDelivery(deliveryId);
    }
}
