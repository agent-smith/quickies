package com.agentsmith.quickies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FindMissingNumber.
 * <p/>
 * User: rmarquez
 * Date: 7/30/13
 * Time: 9:59 PM
 */
public class FindMissingNumberTest
{
    @Test
    public void findMissing0InEmpty() throws Exception
    {
        FindMissingNumber f = new FindMissingNumber();
        int actualMissingNum = f.findMissingNum(new Integer[] { });
        assertEquals(-1, actualMissingNum);
    }

    @Test
    public void findMissing1In2() throws Exception
    {
        FindMissingNumber f = new FindMissingNumber();
        int actualMissingNum = f.findMissingNum(new Integer[] { 2 });
        assertEquals(1, actualMissingNum);
    }

    @Test
    public void findMissing1In3() throws Exception
    {
        FindMissingNumber f = new FindMissingNumber();
        int actualMissingNum = f.findMissingNum(new Integer[] { 2, 3 });
        assertEquals(1, actualMissingNum);
    }

    @Test
    public void findMissing3In5() throws Exception
    {
        FindMissingNumber f = new FindMissingNumber();
        int actualMissingNum = f.findMissingNum(new Integer[] { 1, 2, 4, 5 });
        assertEquals(3, actualMissingNum);
    }

    @Test
    public void findMissing13In50() throws Exception
    {
        FindMissingNumber f = new FindMissingNumber();
        int actualMissingNum = f.findMissingNum(new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, // 13 is missing
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50
        });
        assertEquals(13, actualMissingNum);
    }
}
