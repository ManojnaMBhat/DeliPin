package com.example.smartdelivery.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tracking")
public class TrackingUpdate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deliveryId;
    private Double lat;
    private Double lng;
    private Instant timestamp;
	public TrackingUpdate() {
		super();
	}
	public TrackingUpdate(Long id, Long deliveryId, Double lat, Double lng, Instant timestamp) {
		super();
		this.id = id;
		this.deliveryId = deliveryId;
		this.lat = lat;
		this.lng = lng;
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
    
    
}
