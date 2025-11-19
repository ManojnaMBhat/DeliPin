package com.example.smartdelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupAddress;
    private String dropAddress;
    private Double pickupLat;
    private Double pickupLng;
    private Double dropLat;
    private Double dropLng;

    private Long agentId;
    private String status;
	public Delivery() {
		super();
	}
	public Delivery(Long id, String pickupAddress, String dropAddress, Double pickupLat, Double pickupLng,
			Double dropLat, Double dropLng, Long agentId, String status) {
		super();
		this.id = id;
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.pickupLat = pickupLat;
		this.pickupLng = pickupLng;
		this.dropLat = dropLat;
		this.dropLng = dropLng;
		this.agentId = agentId;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public String getDropAddress() {
		return dropAddress;
	}
	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}
	public Double getPickupLat() {
		return pickupLat;
	}
	public void setPickupLat(Double pickupLat) {
		this.pickupLat = pickupLat;
	}
	public Double getPickupLng() {
		return pickupLng;
	}
	public void setPickupLng(Double pickupLng) {
		this.pickupLng = pickupLng;
	}
	public Double getDropLat() {
		return dropLat;
	}
	public void setDropLat(Double dropLat) {
		this.dropLat = dropLat;
	}
	public Double getDropLng() {
		return dropLng;
	}
	public void setDropLng(Double dropLng) {
		this.dropLng = dropLng;
	}
	public Long getAgentId() {
		return agentId;
	}
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
