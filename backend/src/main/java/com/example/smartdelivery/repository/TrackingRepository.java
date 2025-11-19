package com.example.smartdelivery.repository;

import com.example.smartdelivery.model.TrackingUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrackingRepository extends JpaRepository<TrackingUpdate, Long> {
    List<TrackingUpdate> findByDeliveryIdOrderByTimestampAsc(Long deliveryId);
}
