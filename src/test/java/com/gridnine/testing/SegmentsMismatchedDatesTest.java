package com.gridnine.testing;

import org.gridnine.testing.SegmentsMismatchedDates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.gridnine.testing.TestFlights.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SegmentsMismatchedDatesTest {

    @Test
    @DisplayName("Когда остался вариант с прибытием после отъезда, тогда true")
    void arrivalAfterDeparture() {
        assertTrue(new SegmentsMismatchedDates().Filter(flightWithThreeHourGroundTime));
    }

    @Test
    @DisplayName("Когда остался вариант, где время отъезда и прибытия совпадают, тогда true")
    void arrivalEqualDeparture() {
        assertTrue(new SegmentsMismatchedDates().Filter(flightWithArrivalEqualDeparture));
    }

    @Test
    @DisplayName("Когда остался вариант с прибытием до отъезда, тогда false")
    void arrivalBeforeDeparture() {
        assertFalse(new SegmentsMismatchedDates().Filter(flightWithArrivalBeforeDepartureSegment));
    }
}
