package com.example.smartdelivery.controller;

import com.example.smartdelivery.model.*;
import com.example.smartdelivery.service.RouteService;
import com.example.smartdelivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @PostMapping("/compute")
    public RouteResponse compute(@RequestBody ComputeRequest req) {
        List<Delivery> deliveries = deliveryRepository.findAllById(req.deliveryIds);
        Location start = req.start;
        return routeService.computeRoute(start, deliveries);
    }

    public static class ComputeRequest {
        public Location start;
        public List<Long> deliveryIds;
    }
}
