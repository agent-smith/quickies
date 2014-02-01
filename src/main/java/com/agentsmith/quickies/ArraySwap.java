package com.agentsmith.quickies;

import java.util.Arrays;

import static java.lang.String.format;

/**
 * Swaping two elements of an array.
 * <p/>
 * User: rmarquez
 * Date: 9/28/13
 * Time: 7:23 PM
 */
public class ArraySwap {

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

    public static void main(String[] args) {
        Character[] characters = new Character[] { 'a', 'b', 'c' };
        System.out.println(format("Array of Characters: %s", Arrays.toString(characters)));
        ArraySwap.swap(characters, 0, 2);
        System.out.println(format("Swapping items '%d' and '%d' gives: %s", 0, 2, Arrays.toString(characters)));

        char[] chars = new char[] { 'a', 'b', 'c' };
        System.out.println(format("\nArray of chars: %s", Arrays.toString(chars)));
        ArraySwap.swap(chars, 0, 2);
        System.out.println(format("Swapping items '%d' and '%d' gives: %s", 0, 2, Arrays.toString(chars)));

        int[] ints = new int[] { 1, 2, 3 };
        System.out.println(format("\nArray of ints: %s", Arrays.toString(ints)));
        ArraySwap.swap(ints, 0, 2);
        System.out.println(format("Swapping items '%d' and '%d' gives: %s", 0, 2, Arrays.toString(ints)));
    }
}
