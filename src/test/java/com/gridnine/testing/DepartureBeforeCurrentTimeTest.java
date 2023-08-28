package com.gridnine.testing;

import org.gridnine.testing.DepartureBeforeCurrentTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.gridnine.testing.TestFlights.flightWithDepartureInThePast;
import static org.gridnine.testing.TestFlights.flightWithThreeHourGroundTime;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartureBeforeCurrentTimeTest {

    @Test
    @DisplayName("Когда остался вариант с вылетом после текущего момента времени, тогда true")
    void departureInTheFuture() {
        assertTrue(new DepartureBeforeCurrentTime().Filter(flightWithThreeHourGroundTime));
    }

    @Test
    @DisplayName("Когда остался вариант с вылетом до текущего момента времени, тогда false")
    void departureInThePast() {
        assertFalse(new DepartureBeforeCurrentTime().Filter(flightWithDepartureInThePast));
    }
}
