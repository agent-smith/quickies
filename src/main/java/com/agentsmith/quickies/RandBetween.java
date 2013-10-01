package com.agentsmith.quickies;

import static java.lang.String.format;

/**
 * Given two integers, finds a random int between them (inclusive).
 * <p/>
 * User: rmarquez
 * Date: 8/25/13
 * Time: 3:56 PM
 */
public class RandBetween
{
    public static int findRandBetween(int lo, int hi) {
        return lo + (int) (Math.random() * (hi - lo + 1));
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            int lo = Integer.valueOf(args[0]);
            int hi = Integer.valueOf(args[1]);

            if (lo > hi) {
                throw new RuntimeException(
                        format("First arg '%d' must be less than or equal to second arg '%d'", lo, hi));
            }

            System.out.println(format("Random # between %d and %d: %d", lo, hi, findRandBetween(lo, hi)));
        } else {
            System.out.println(format("Random # between %d and %d: %d", 1, 10, findRandBetween(1, 10)));
        }
    }
}
