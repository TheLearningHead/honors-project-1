package com.example.honors_project_1.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class Ticket {
    private Long id;
    private Long flightId;
    private LocalDate travelDate;
    private String passengerName;
    private String bookingReference;
}
