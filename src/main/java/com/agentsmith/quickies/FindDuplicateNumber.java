package com.agentsmith.quickies;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N numbers, where N > 0.  Find the duplicate number in an array of N+1 integers.
 * e.g. given { 1, 2, 3, 3, 5 } , the duplicate number is 3.
 * <p/>
 * User: rmarquez
 * Date: 2/1/2014
 * Time: 18:28
 */
public class FindDuplicateNumber
{
    // Thanks to Euler, we know that totaling the numbers between 1..N is the same as: N(N+1)/2
    // So, we calculate that number, and subtract the actual total to get our answer.
    // Also, if the nums passed in is empty, just return -1.
    public static int findDuplicateNum(Integer[] nums)
    {
        if (nums.length < 1)
        {
            return -1;
        }

        // Validate that the numbers start at 1.
        assert(nums[0] == 1);

        // In the case that there's only 2 elements, the duplicate number should be 1, so no need to do anything else.
        if (nums.length == 2 && nums[0] == 1)
        {
            return 1;
        }

        int totalNums = nums.length - 1;

        int expectedTotal = totalNums * (totalNums + 1) / 2;
        int actualTotal = sum(nums);

        return actualTotal - expectedTotal;
    }

    private static int sum(Integer[] nums)
    {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int nextNum = nums[i];

            // Validate that the numbers are consecutive.
            assert(i < 1 || nextNum == nums[i-1] + 1 || nextNum == nums[i-1]);

            sum += nextNum;
        }
        return sum;
    }

    // Usage: FindDuplicateNumber <N> <expected_duplicate_number>
    // For example, "FindDuplicateNumber 5 3" should return 3.
    // In the example above, an array is built, which contain 3 twice: { 1, 2, 3, 3, 4, 5}, and passed to findDuplicateNum()
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int duplicateNumExpected = Integer.parseInt(args[1]);

        List<Integer> nums = new ArrayList<>(N+1);
        for (int i = 1; i < N+1; i++)
        {
            nums.add(i);

            if (i == duplicateNumExpected)
            {
                nums.add(i);
            }
        }

        System.out.println("Finding the duplicate number '" + duplicateNumExpected + "', in 1.." + N);
        System.out.println("nums = " + nums + "");

        int duplicateNumActual = FindDuplicateNumber.findDuplicateNum(nums.toArray(new Integer[N+1]));

        System.out.println("Duplicate number is: " + duplicateNumActual);
    }
}
