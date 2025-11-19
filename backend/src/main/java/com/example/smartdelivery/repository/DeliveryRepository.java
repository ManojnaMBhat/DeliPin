package com.example.smartdelivery.repository;

import com.example.smartdelivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
