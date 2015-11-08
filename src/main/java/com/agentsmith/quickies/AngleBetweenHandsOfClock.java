package com.agentsmith.quickies;

import static java.lang.Math.abs;

/**
 * Given an hour and minute (e.g. 3:25) of an analog clock, irrespective of AM/PM,
 * find the angle between the hour and minute hand.
 *
 * Created by agentsmith on 2015-11-07.
 */
public class AngleBetweenHandsOfClock {

    private static final int HOURS_IN_360_DEGREES = 12;
    private static final int MINUTES_IN_360_DEGREES = 60;

    private static final double ONE_HOUR_ANGLE = 360 / HOURS_IN_360_DEGREES;     // 360/12 = 30
    private static final double ONE_MINUTE_ANGLE = 360 / MINUTES_IN_360_DEGREES; // 360/60 = 6

    private static final double HOUR_ANGLE_PER_MINUTE = ONE_HOUR_ANGLE / MINUTES_IN_360_DEGREES; // 30/60 = 0.5

    public static double findAngleBetween(int hour, int minute) {
        double hourAngle = (ONE_HOUR_ANGLE * hour) + (HOUR_ANGLE_PER_MINUTE * minute);
        double minuteAngle = ONE_MINUTE_ANGLE * minute;
        return abs(hourAngle - minuteAngle) % 360; // mod just in case it's 12:00, so we get 0 instead of 360
    }

}