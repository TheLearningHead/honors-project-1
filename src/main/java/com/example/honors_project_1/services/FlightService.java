package com.example.honors_project_1.services;

import com.example.honors_project_1.dto.Flight;
import com.example.honors_project_1.dto.Schedule;
import com.example.honors_project_1.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(String sort) {
        return flightRepository.getAllFlights(sort);
    }

    public Flight getOneFlight(Long flightId) {
        return flightRepository.getOneFlight(flightId);
    }

    public List<Schedule> getSchedule(Long flightId, LocalDate date) {
        return flightRepository.getSchedule(flightId, date);
    }
}
