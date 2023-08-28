package org.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterService {

    private final FlightFilter filter;

    public FlightFilterService(FlightFilter filter) {
        this.filter = filter;
    }

    /**
     * Отбирает список перелетов по заданному фильтру
     *
     * @param flights
     * @return List<Flight>
     */
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(filter::Filter)
                .collect(Collectors.toList());
    }
}
