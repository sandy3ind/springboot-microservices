package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.model.Location;

@Controller
public class LocationController {

	@MessageMapping("/location")
    @SendTo("/topic/location")
    public Location location(Location location) throws Exception {
        return location;
    }
}
