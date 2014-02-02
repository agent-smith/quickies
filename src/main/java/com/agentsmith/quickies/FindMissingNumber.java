package com.agentsmith.quickies;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N numbers, where N > 0.  Find the missing number in an array of N-1 integers.
 * e.g. given { 1, 2, 4, 5 } , the missing number is 3.
 */
public class FindMissingNumber
{
    // Thanks to Euler, we know that totaling the numbers between 1..N is the same as: N(N+1)/2
    // So, we calculate that number, and subtract the actual total to get our answer.
    // Also, if the nums passed in is empty, just return -1.
    public int findMissingNum(Integer[] nums)
    {
        if (nums.length < 1)
        {
            return -1;
        }

        // Validate that the numbers start at 1 or 2.
        assert(nums[0] == 1 || nums[0] == 2);

        // In the case that it starts at 2, the missing number should be 1, so no need to do anything else.
        if (nums[0] == 2)
        {
            return 1;
        }

        int totalNums = nums.length + 1;
        int expectedTotal = totalNums * (totalNums + 1) / 2;
        int actualTotal = 0;

        for (int i = 0; i < nums.length; i++)
        {
            int nextNum = nums[i];

            // Validate that the numbers are consecutive.
            assert(i < 1 || nextNum == nums[i-1] + 1 || nextNum == nums[i-1] + 2);

            actualTotal += nextNum;
        }
        return expectedTotal - actualTotal;
    }

    // Usage: FindMissingNumber <N> <expected_missing_number>
    // For example, "FindMissingNumber 5 3" should return 3.
    // In the example above, an array is built, which does not contain 3: { 1, 2, 4, 5}, and passed to findMissingNum()
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int missingNumExpected = Integer.parseInt(args[1]);

        List<Integer> nums = new ArrayList<>(N-1);
        for (int i = 1; i < N+1; i++)
        {
            if (i != missingNumExpected)
            {
                nums.add(i);
            }
        }

        System.out.println("Finding the missing number '" + missingNumExpected + "', in 1.." + N);
        System.out.println("nums = "+nums+"");

        FindMissingNumber f = new FindMissingNumber();
        int missingNumActual = f.findMissingNum(nums.toArray(new Integer[N-1]));

        System.out.println("Missing number is: " + missingNumActual);
    }
}
