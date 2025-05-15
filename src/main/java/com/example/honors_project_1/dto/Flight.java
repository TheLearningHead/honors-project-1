package com.example.honors_project_1.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Flight {
    private Long id;
    private String airline;
    private String source;
    private String destination;
    private List<Schedule> schedules;
}
