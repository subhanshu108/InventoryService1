package com.example.inventoryservice.response;

import com.example.inventoryservice.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {
    private String name;
    private Long leftCapacity;
    private Venue venue;

//    public EventInventoryResponse(String name, Long leftCapacity, Venue venue) {
//        this.name = name;
//        this.leftCapacity = leftCapacity;
//        this.venue = venue;
//    }
}
