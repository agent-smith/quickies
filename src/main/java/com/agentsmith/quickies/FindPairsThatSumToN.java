package com.agentsmith.quickies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find all pairs of integers that sum to number N.
 * e.g. given { 10, -5, 20, 0, -10 }, the pairs that sum to 10 are: (0, 10) and (-10, 20)
 */
public class FindPairsThatSumToN
{
    /**
     * This approach does not sort the array first.  It keeps track of all differences in a Map<Integer, Integer>,
     * where the key is nextNum and the value is (N - nextNum).  Then, as we linearly search through the array of nums,
     * we check whether the array of nums contains (N - nextNum).  If so, then that's a match.  If not,
     * then add (nextNum, (N - nextNum)) to the map and keep traversing the array.
     */
    public Map<Integer, Integer> findPairsNoSort(int[] nums, int N)
    {
        Map<Integer, Integer> result = new HashMap<>();

        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int nextNum : nums)
        {
            int diff = N-nextNum;
            if (diffMap.containsKey(diff))
            {
                result.put(nextNum, diff);
            }
            else
            {
                diffMap.put(nextNum, diff);
            }
        }

        return result;
    }

    /**
     * This approach sorts the array first.  It keeps 2 pointers.  One at the start of the array,
     * and one at the end of the array.  If the current numbers sum to N, then that's a pair.  Otherwise,
     * if the sum of the first and last number is less than N, then advance the first pointer.  Or,
     * if the sum of the first and the last number is greater than N, advnace the last pointer.
     */
    public Map<Integer, Integer> findPairsSort(int[] nums, int N)
    {
        Map<Integer, Integer> result = new HashMap<>();

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j)
        {
            int sum = nums[i] + nums[j];
            if (sum == N)
            {
                result.put(nums[i], nums[j]);
                i++;
                j--;
            }
            else if (sum < N)
            {
                i++;
            }
            else
            {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] { 10, -5, 20, 0, -10 };
        int N = 10;

        System.out.println("Finding all pairs that sum to " + N + ", without sorting the array first.");
        FindPairsThatSumToN f1 = new FindPairsThatSumToN();
        Map<Integer, Integer> result = f1.findPairsNoSort(nums, N);
        System.out.println("All pairs: " + result);

        System.out.println("Finding all pairs that sum to " + N + ", first by sorting the array.");
        FindPairsThatSumToN f2 = new FindPairsThatSumToN();
        result = f2.findPairsSort(nums, N);
        System.out.println("All pairs: " + result);
    }
}
