package com.example.smartdelivery.service;

import com.example.smartdelivery.model.TrackingUpdate;
import com.example.smartdelivery.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    public TrackingUpdate saveUpdate(TrackingUpdate update) {
        if (update.getTimestamp() == null) update.setTimestamp(Instant.now());
        return trackingRepository.save(update);
    }

    public List<TrackingUpdate> getTrackingForDelivery(Long deliveryId) {
        return trackingRepository.findByDeliveryIdOrderByTimestampAsc(deliveryId);
    }
}
