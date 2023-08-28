package org.gridnine.testing;

public class SegmentsMismatchedDates implements FlightFilter {

    /**
     * Фильтр исключает варианты с сегментами,
     * где дата прилёта раньше даты вылета
     * и возвращает true, иначе - false
     *
     * @param flight
     * @return true/false
     */
    @Override
    public boolean Filter(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate()));
    }
}
