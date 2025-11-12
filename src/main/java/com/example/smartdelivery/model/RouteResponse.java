package com.example.smartdelivery.model;

import java.util.List;

public class RouteResponse {
    private double distanceMeters;
    private long durationSeconds;
    private List<Location> path;
	public RouteResponse() {
		super();
	}
	public RouteResponse(double distanceMeters, long durationSeconds, List<Location> path) {
		super();
		this.distanceMeters = distanceMeters;
		this.durationSeconds = durationSeconds;
		this.path = path;
	}
	public double getDistanceMeters() {
		return distanceMeters;
	}
	public void setDistanceMeters(double distanceMeters) {
		this.distanceMeters = distanceMeters;
	}
	public long getDurationSeconds() {
		return durationSeconds;
	}
	public void setDurationSeconds(long durationSeconds) {
		this.durationSeconds = durationSeconds;
	}
	public List<Location> getPath() {
		return path;
	}
	public void setPath(List<Location> path) {
		this.path = path;
	}
    
}
