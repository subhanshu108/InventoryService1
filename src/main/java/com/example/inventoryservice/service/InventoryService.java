package com.example.inventoryservice.service;


import com.example.inventoryservice.entity.Event;
import com.example.inventoryservice.entity.Venue;
import com.example.inventoryservice.repository.EventRepository;
import com.example.inventoryservice.repository.VenueRepository;
import com.example.inventoryservice.response.EventInventoryResponse;
import com.example.inventoryservice.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InventoryService {


    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public InventoryService(final EventRepository eventRepository, final VenueRepository venueRepository){
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }
    public List<EventInventoryResponse> getAllEvents() {
        final List<Event> events = eventRepository.findAll();
        List<EventInventoryResponse> eventInventoryResponses = new ArrayList<>();
        for (Event event : events) {
            EventInventoryResponse eventInventoryResponse = new EventInventoryResponse(event.getName(), event.getLeftCapacity(), event.getVenue());
            eventInventoryResponses.add(eventInventoryResponse);
        }
        return eventInventoryResponses;
    }

    public VenueInventoryResponse getVenueInformation(Long venueId) {

        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("venueId not found"));
        return new VenueInventoryResponse(venue.getId(), venue.getName(), venue.getTotalCapacity());
    }
}
