package com.agentsmith.quickies;

import java.util.Arrays;

import static java.lang.String.format;

/**
 * // TODO: impl me!
 * <p/>
 * User: rmarquez
 * Date: 9/28/13
 * Time: 7:23 PM
 */
public class ArraySwap
{
    public static <T> void swap(T[] arr, int a, int b)
    {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args)
    {
        Character[] charArray = new Character[] { 'a', 'b', 'c' };

        System.out.println(format("Array of characters: %s", Arrays.toString(charArray)));

        ArraySwap.swap(charArray, 0, 2);

        System.out.println(format("Swapping items '%d' and '%d' gives: %s", 0, 2, Arrays.toString(charArray)));
    }
}
