package org.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class TotalGroundTime implements FlightFilter {

    private final Duration maxGroundTime;

    public TotalGroundTime(Duration maxGroundTime) {
        this.maxGroundTime = maxGroundTime;
    }

    /**
     * Фильтр исключает варианты с общим временем,
     * проведённым на земле, которое превышает 2 часа
     * и возвращает true, иначе - false
     *
     * @param flight
     * @return true/false
     */
    @Override
    public boolean Filter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() >= 2) {
            long groundTime = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime currentArrival = segments.get(i).getArrivalDate();
                LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                groundTime += Duration.between(currentArrival, nextDeparture).toHours();
            }
            return groundTime <= maxGroundTime.toHours();
        }
        return false;
    }
}
