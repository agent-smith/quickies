package com.agentsmith.quickies;

import java.util.Arrays;

/**
 * Shuffle an array.
 * <p/>
 * User: rmarquez
 * Date: 9/30/13
 * Time: 9:46 PM
 */
public class Shuffler
{
    public static <T> void shuffle(T[] arr) {
        for (int i = 0; i<arr.length; i++) {
            int randIdx = RandBetween.findRandBetween(i, arr.length - 1);
            ArraySwap.swap(arr, i, randIdx);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Suffling the following: " + Arrays.toString(arr));
        Shuffler.shuffle(arr);
        System.out.println("Result: " + Arrays.toString(arr));

        String[] deck = new String[] {
                "Ad", "Kd", "Qd", "Jd", "10d", "9d", "8d", "7d", "6d", "5d", "4d", "3d", "2d",
                "Ac", "Kc", "Qc", "Jc", "10c", "9c", "8c", "7c", "6c", "5c", "4c", "3c", "2c",
                "Ah", "Kh", "Qh", "Jh", "10h", "9h", "8h", "7h", "6h", "5h", "4h", "3h", "2h",
                "As", "Ks", "Qs", "Js", "10s", "9s", "8s", "7s", "6s", "5s", "4s", "3s", "2s",
        };
        System.out.println("Suffling the following: " + Arrays.toString(deck));
        Shuffler.shuffle(deck);
        System.out.println("Result: " + Arrays.toString(deck));
    }
}
