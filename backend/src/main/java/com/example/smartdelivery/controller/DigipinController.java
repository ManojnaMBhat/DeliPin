package com.example.smartdelivery.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartdelivery.client.DigipinClient;
import com.example.smartdelivery.model.DigipinRequest;

@RestController
@RequestMapping("/api/digipin")
public class DigipinController {
	private final DigipinClient digipinClient;

    public DigipinController(DigipinClient digipinClient) {
        this.digipinClient = digipinClient;
    }
   @PostMapping("/decode")
    public Map<String, Object> decodePin(@RequestBody DigipinRequest request) {
        Map<String, Object> itemLocation = digipinClient.decodePin(request.getItemDigipin());
        Map<String, Object> deliveryLocation = digipinClient.decodePin(request.getDeliveryDigipin());

        return Map.of(
            "itemLocation", itemLocation,
            "deliveryLocation", deliveryLocation
        );
        
    }
}
	

