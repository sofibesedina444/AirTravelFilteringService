package org.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureBeforeCurrentTime implements FlightFilter {

    /**
     * Фильтр исключает варианты с вылетом до текущего момента времени
     * и возвращает true, иначе - false
     *
     * @param flight
     * @return true/false
     */
    @Override
    public boolean Filter(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(s -> s.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
