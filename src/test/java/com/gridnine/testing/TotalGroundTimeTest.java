package com.gridnine.testing;

import org.gridnine.testing.TotalGroundTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.gridnine.testing.TestFlights.*;
import static org.junit.jupiter.api.Assertions.*;

public class TotalGroundTimeTest {

    @Test
    @DisplayName("Когда остались сегменты с общим временем, не превышающем 2 часа, тогда true")
    void OneHoursGroundTime() {
        assertTrue(new TotalGroundTime(Duration.ofHours(2)).Filter(flightWithTwoHourGroundTime));
    }

    @Test
    @DisplayName("Когда остались сегменты с общим временем, превышающем 2 часа, тогда false")
    void ThreeHoursGroundTime() {
        assertFalse(new TotalGroundTime(Duration.ofHours(2)).Filter(flightWithThreeHourGroundTime));
    }

    @Test
    @DisplayName("Когда остался полет с одним сегментом, тогда false")
    void zeroGroundTime() {
        assertFalse(new TotalGroundTime(Duration.ofHours(2)).Filter(flightWithOneNormalSegment));
    }
}
