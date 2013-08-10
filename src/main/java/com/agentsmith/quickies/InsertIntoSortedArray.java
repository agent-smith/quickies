package com.agentsmith.quickies;

import java.util.Arrays;

/**
 * Insert a new element into an already sorted array.
 * <p/>
 * e.g. Inserting 7 into sorted array { 3, 4, 5, 6, 8, 9, 10, 11, 12, 13 }, will give a new array:
 * { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }
 * <p/>
 * The search happens in lg(N) time to find the position where the new element should be inserted.  But,
 * then temporary arrays are created when System.arraycopy is used to copy the contents into the left hand side and
 * right hand side of the resulting array.
 * <p/>
 * User: rmarquez
 * Date: 8/10/13
 * Time: 11:36 AM
 */
public class InsertIntoSortedArray
{
    private int[] arr;

    public InsertIntoSortedArray(int[] sortedArr)
    {
        arr = sortedArr;
    }

    public int[] add(int key) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return arr;
            }
        }

        int[] result = new int[arr.length+1];

        // lo == hi at this point, so reassign mid to lo so it's easier to comprehend the copying from the original
        // array to the resulting array.
        mid = (key < arr[lo]) ? lo : lo+1;

        // Copy left side of original array to resulting array.
        System.arraycopy(arr, 0, result, 0, mid);

        // Copy right side of original array to resulting array (starting at resulting array's mid+1 element).
        System.arraycopy(arr, mid, result, mid+1, arr.length-mid);

        // Finally, fill in the empty mid in the resulting array.
        result[mid] = key;

        return result;
    }

    public static void main(String[] args)
    {
        int sortedArr1[] = new int[] { 3, 4, 6, 7, 8, 9, 10 };
        System.out.println("Adding key '5' to sorted array: " + Arrays.toString(sortedArr1));
        InsertIntoSortedArray f1 = new InsertIntoSortedArray(sortedArr1);
        int[] result1 = f1.add(5);
        System.out.println("Resulting array: " + Arrays.toString(result1));

        int[] sortedArr2 = new int[] { 3, 4, 5, 6, 8, 9, 10, 11, 12, 13 };
        System.out.println("Adding key '7' to sorted array: " + Arrays.toString(sortedArr2));
        InsertIntoSortedArray f2 = new InsertIntoSortedArray(sortedArr2);
        int[] result2 = f2.add(7);
        System.out.println("Resulting array: " + Arrays.toString(result2));
    }
}
