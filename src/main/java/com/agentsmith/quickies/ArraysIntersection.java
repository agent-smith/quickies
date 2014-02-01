package com.agentsmith.quickies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Various methods of finding the intersection of 2 arrays.  The various methods make time vs. space complexity
 * trade-offs.
 * <p/>
 * User: rmarquez
 * Date: 12/27/2013
 * Time: 8:35 PM
 */
public class ArraysIntersection {

    private static final double MAX_RATIO = 1e-6;

    public static <T extends Comparable<T>> T[] intersection(T[] a, T[] b, int maxExtraSpace) {

        if (a.length + b.length <= maxExtraSpace) {
            return setToArray((a.length < b.length) ? intersectionWithExtraSpace(a, b)
                                                    : intersectionWithExtraSpace(b, a));

        } else if (arr1MuchSmallerThanArr2(a, b)) {
            return setToArray(intersectionWithBinarySearch(a, b));

        } else if (arr1MuchSmallerThanArr2(b, a)) {
            return setToArray(intersectionWithBinarySearch(b, a));
        }

        return setToArray(intersectionWithPointers(a, b));
    }

    private static <T> boolean arr1MuchSmallerThanArr2(T[] arr1, T[] arr2) {
        return (arr1.length < arr2.length) && (1.0 * arr1.length / arr2.length < MAX_RATIO);
    }

    private static <T extends Comparable<T>> Set<T> intersectionWithExtraSpace(T[] arr1, T[] arr2) {
        System.out.print("Calculating Intersection (using extra space)... ");

        Set<T> extra = new HashSet<>(arr1.length);
        for (T next : arr1) {
            extra.add(next);
        }

        Set<T> result = new HashSet<>(arr1.length);
        for (T next : arr2) {
            if (extra.contains(next)) {
                result.add(next);
            }
        }
        return result;
    }

    private static <T extends Comparable<T>> Set<T> intersectionWithBinarySearch(T[] smallerArr, T[] largerArr) {
        System.out.print("Calculating Intersection (using binary search)... ");

        Heap.sort(largerArr);

        Set<T> result = new HashSet<>();
        for (T next : smallerArr) {
            int idxOfNext = Arrays.binarySearch(largerArr, next);
            if (idxOfNext > -1) {
                result.add(next);
            }
        }
        return result;
    }

    private static <T extends Comparable<T>> Set<T> intersectionWithPointers(T[] arr1, T[] arr2) {
        System.out.print("Calculating Intersection (using pointers)... ");

        Set<T> result = new HashSet<>();

        Heap.sort(arr1);
        Heap.sort(arr2);

        int arr1Idx = arr1.length - 1;
        int arr2Idx = arr2.length - 1;

        while (arr1Idx > -1 && arr2Idx > -1) {
            if (arr1[arr1Idx].compareTo(arr2[arr2Idx]) == 0) {
                result.add(arr1[arr1Idx]);
                --arr1Idx;
                --arr2Idx;
            } else if (arr1[arr1Idx].compareTo(arr2[arr2Idx]) < 0) {
                --arr2Idx;
            } else {
                --arr1Idx;
            }
        }

        return result;
    }

    @SuppressWarnings({ "unchecked", "SuspiciousToArrayCall" })
    private static <T extends Comparable<T>> T[] setToArray(Set<T> set) {
        return (T[]) set.toArray(new Comparable[set.size()]);
    }

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[] { 10, 18, 22, 8, 5, 30 };
        Integer[] arr2 = new Integer[] { 2, 23, 15, 10, 1, 5, 21, 30, 100, 3 };

        System.out.println("Finding intersection of the following 2 arrays:" +
                           "\n" + Arrays.toString(arr1) +
                           "\n" + Arrays.toString(arr2));

        System.out.println(Arrays.toString(intersection(arr1, arr2, Integer.MAX_VALUE)));

        //////////////////////////

        System.out.println(Arrays.toString(intersection(arr1, arr2, 0)));

        //////////////////////////

        int arr2Size = ((int) (1 / MAX_RATIO)) * 10;
        arr1 = new Integer[] { 4, 2, 3 };
        arr2 = createArrayOfN(arr2Size);

        System.out.println("\nFinding intersection of array containing numbers 0.." + (arr2Size - 1) +
                           " and much smaller array " + Arrays.toString(arr1));
        System.out.println(Arrays.toString(intersection(arr1, arr2, 0)));
    }

    private static Integer[] createArrayOfN(int N) {
        List<Integer> result = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            result.add(i);
        }
        return result.toArray(new Integer[N]);
    }
}
