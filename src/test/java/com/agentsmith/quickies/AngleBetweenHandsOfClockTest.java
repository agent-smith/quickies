package com.agentsmith.quickies;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for AngleBetweenHandsOfClock.
 *
 * Created by agentsmith on 2015-11-07.
 */
public class AngleBetweenHandsOfClockTest {

    @Test
    public void findAngleBetween() throws Exception {

        // 1:00, 2:00, ..., 11:00
        for (int i = 1; i <= 11; i++) {
            assertEquals(i * 30, AngleBetweenHandsOfClock.findAngleBetween(i, 0), 0.0);
        }

        // 12:00
        assertEquals(0.0, AngleBetweenHandsOfClock.findAngleBetween(12, 0), 0.0);

        // 3:25
        assertEquals(47.5, AngleBetweenHandsOfClock.findAngleBetween(3, 25), 0.0);
    }
}
