package org.gridnine.testing;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Тестовый набор рейсов:");
        flights.forEach(System.out::println);

        DepartureBeforeCurrentTime filter1 = new DepartureBeforeCurrentTime();
        FlightFilterService FirstFilterService = new FlightFilterService(filter1);
        List<Flight> FlightsAfterFirstFilter = FirstFilterService.filterFlights(flights);
        System.out.println("Отфильтрованные рейсы по первому правилу:");
        FlightsAfterFirstFilter.forEach(System.out::println);

        SegmentsMismatchedDates filter2 = new SegmentsMismatchedDates();
        FlightFilterService SecondFilterService = new FlightFilterService(filter2);
        List<Flight> FlightsAfterSecondFilter = SecondFilterService.filterFlights(flights);
        System.out.println("Отфильтрованные рейсы по второму правилу:");
        FlightsAfterSecondFilter.forEach(System.out::println);

        TotalGroundTime filter3 = new TotalGroundTime(Duration.ofHours(2));
        FlightFilterService ThirdFilterService = new FlightFilterService(filter3);
        List<Flight> FlightsAfterThirdFilter = ThirdFilterService.filterFlights(flights);
        System.out.println("Отфильтрованные рейсы по третьему правилу:");
        FlightsAfterThirdFilter.forEach(System.out::println);
    }
}