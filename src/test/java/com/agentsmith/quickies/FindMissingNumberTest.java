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
}
