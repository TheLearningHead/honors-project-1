package com.example.honors_project_1.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder(toBuilder = true)
public class Schedule {
    private Long id;
    private Long flightId;
    private LocalDate date;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
}
