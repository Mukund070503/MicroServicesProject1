package com.Icwd.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Icwd.hotel.entities.Hotel;
import com.Icwd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Create Hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    // Get one hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(id));
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAll());
    }
}
