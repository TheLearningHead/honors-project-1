package com.example.honors_project_1.repository;

import com.example.honors_project_1.dto.Flight;
import com.example.honors_project_1.dto.Schedule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FlightRepository {
    private Map<Long, Flight> flightTable;
    private Map<Long, List<Schedule>> scheduleTable;

    @PostConstruct
    public void init() {
        flightTable = new HashMap<>();
        scheduleTable = new HashMap<>();

        // Dumping static flight data
        Flight flight1 = Flight.builder().id(1L).airline("IndiGo").source("Nagpur").destination("Mumbai").schedules(new ArrayList<>()).build();
        Flight flight2 = Flight.builder().id(2L).airline("Air India").source("Delhi").destination("Bangalore").schedules(new ArrayList<>()).build();
        Flight flight3 = Flight.builder().id(3L).airline("SpiceJet").source("Pune").destination("Hyderabad").schedules(new ArrayList<>()).build();
        Flight flight4 = Flight.builder().id(4L).airline("GoAir").source("Chennai").destination("Kolkata").schedules(new ArrayList<>()).build();
        Flight flight5 = Flight.builder().id(5L).airline("Vistara").source("Mumbai").destination("Goa").schedules(new ArrayList<>()).build();

        flightTable.put(1L, flight1);
        flightTable.put(2L, flight2);
        flightTable.put(3L, flight3);
        flightTable.put(4L, flight4);
        flightTable.put(5L, flight5);

        // Dumping static schedule data
        scheduleTable.put(1L, Arrays.asList(
                Schedule.builder().id(101L).flightId(1L).date(LocalDate.of(2025, 3, 20)).departureTime(LocalTime.of(10, 30)).arrivalTime(LocalTime.of(12, 30)).availableSeats(50).build(),
                Schedule.builder().id(102L).flightId(1L).date(LocalDate.of(2025, 3, 21)).departureTime(LocalTime.of(14, 00)).arrivalTime(LocalTime.of(16, 00)).availableSeats(30).build(),
                Schedule.builder().id(103L).flightId(1L).date(LocalDate.of(2025, 3, 22)).departureTime(LocalTime.of(18, 00)).arrivalTime(LocalTime.of(20, 00)).availableSeats(20).build(),
                Schedule.builder().id(104L).flightId(1L).date(LocalDate.of(2025, 3, 23)).departureTime(LocalTime.of(8, 00)).arrivalTime(LocalTime.of(10, 00)).availableSeats(40).build(),
                Schedule.builder().id(105L).flightId(1L).date(LocalDate.of(2025, 3, 24)).departureTime(LocalTime.of(12, 00)).arrivalTime(LocalTime.of(14, 00)).availableSeats(35).build()
        ));

        scheduleTable.put(2L, Arrays.asList(
                Schedule.builder().id(106L).flightId(2L).date(LocalDate.of(2025, 3, 20)).departureTime(LocalTime.of(9, 00)).arrivalTime(LocalTime.of(11, 30)).availableSeats(40).build(),
                Schedule.builder().id(107L).flightId(2L).date(LocalDate.of(2025, 3, 21)).departureTime(LocalTime.of(13, 00)).arrivalTime(LocalTime.of(15, 30)).availableSeats(50).build(),
                Schedule.builder().id(108L).flightId(2L).date(LocalDate.of(2025, 3, 22)).departureTime(LocalTime.of(17, 00)).arrivalTime(LocalTime.of(19, 30)).availableSeats(45).build(),
                Schedule.builder().id(109L).flightId(2L).date(LocalDate.of(2025, 3, 23)).departureTime(LocalTime.of(6, 00)).arrivalTime(LocalTime.of(8, 30)).availableSeats(25).build(),
                Schedule.builder().id(110L).flightId(2L).date(LocalDate.of(2025, 3, 24)).departureTime(LocalTime.of(11, 00)).arrivalTime(LocalTime.of(13, 30)).availableSeats(60).build()
        ));

        scheduleTable.put(3L, Arrays.asList(
                Schedule.builder().id(111L).flightId(3L).date(LocalDate.of(2025, 3, 20)).departureTime(LocalTime.of(7, 30)).arrivalTime(LocalTime.of(9, 30)).availableSeats(55).build(),
                Schedule.builder().id(112L).flightId(3L).date(LocalDate.of(2025, 3, 21)).departureTime(LocalTime.of(16, 00)).arrivalTime(LocalTime.of(18, 00)).availableSeats(35).build(),
                Schedule.builder().id(113L).flightId(3L).date(LocalDate.of(2025, 3, 22)).departureTime(LocalTime.of(20, 00)).arrivalTime(LocalTime.of(22, 00)).availableSeats(20).build(),
                Schedule.builder().id(114L).flightId(3L).date(LocalDate.of(2025, 3, 23)).departureTime(LocalTime.of(9, 00)).arrivalTime(LocalTime.of(11, 00)).availableSeats(30).build(),
                Schedule.builder().id(115L).flightId(3L).date(LocalDate.of(2025, 3, 24)).departureTime(LocalTime.of(15, 00)).arrivalTime(LocalTime.of(17, 00)).availableSeats(45).build()
        ));

        scheduleTable.put(4L, Arrays.asList(
                Schedule.builder().id(116L).flightId(4L).date(LocalDate.of(2025, 3, 20)).departureTime(LocalTime.of(11, 00)).arrivalTime(LocalTime.of(13, 00)).availableSeats(60).build(),
                Schedule.builder().id(117L).flightId(4L).date(LocalDate.of(2025, 3, 21)).departureTime(LocalTime.of(14, 00)).arrivalTime(LocalTime.of(16, 00)).availableSeats(50).build(),
                Schedule.builder().id(118L).flightId(4L).date(LocalDate.of(2025, 3, 22)).departureTime(LocalTime.of(19, 00)).arrivalTime(LocalTime.of(21, 00)).availableSeats(40).build()
        ));

        scheduleTable.put(5L, Arrays.asList(
                Schedule.builder().id(119L).flightId(5L).date(LocalDate.of(2025, 3, 20)).departureTime(LocalTime.of(10, 00)).arrivalTime(LocalTime.of(12, 00)).availableSeats(30).build(),
                Schedule.builder().id(120L).flightId(5L).date(LocalDate.of(2025, 3, 21)).departureTime(LocalTime.of(12, 30)).arrivalTime(LocalTime.of(14, 30)).availableSeats(35).build(),
                Schedule.builder().id(121L).flightId(5L).date(LocalDate.of(2025, 3, 22)).departureTime(LocalTime.of(18, 30)).arrivalTime(LocalTime.of(20, 30)).availableSeats(25).build()
        ));
    }

    // 1️⃣ Get all flights with sorting (asc or dsc)
    public List<Flight> getAllFlights(String sort) {
        return flightTable.values()
                .stream()
                .sorted(Comparator.comparing(Flight::getId,
                        "asc".equalsIgnoreCase(sort) ? Comparator.naturalOrder() : Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    // 2️⃣ Get a single flight by ID (without schedules)
    public Flight getOneFlight(Long flightId) {
        return flightTable.get(flightId);
    }

    // 3️⃣ Get schedules for a flight on a specific date
    public List<Schedule> getSchedule(Long flightId, LocalDate date) {
        return scheduleTable.getOrDefault(flightId, Collections.emptyList())
                .stream()
                .filter(schedule -> schedule.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
