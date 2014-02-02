package com.agentsmith.quickies;

import org.junit.Test;

import static com.agentsmith.quickies.FindDuplicateNumber.findDuplicateNum;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FindDuplicateNumber.
 * <p/>
 * User: rmarquez
 * Date: 2/1/2014
 * Time: 18:52
 */
public class FindDuplicateNumberTest
{
    @Test
    public void findDuplicate0InEmpty() throws Exception
    {
        int actualDuplicateNum = findDuplicateNum(new Integer[] { });
        assertEquals(-1, actualDuplicateNum);
    }

    @Test
    public void findDuplicate1In1() throws Exception
    {
        int actualDuplicateNum = findDuplicateNum(new Integer[] { 1, 1 });
        assertEquals(1, actualDuplicateNum);
    }

    @Test
    public void findDuplicate1In2() throws Exception
    {
        int actualDuplicateNum = findDuplicateNum(new Integer[] { 1, 1, 2 });
        assertEquals(1, actualDuplicateNum);
    }

    @Test
    public void findDuplicate3In4() throws Exception
    {
        int actualDuplicateNum = findDuplicateNum(new Integer[] { 1, 2, 3, 3, 4 });
        assertEquals(3, actualDuplicateNum);
    }

    @Test
    public void findDuplicate13In50() throws Exception
    {
        int actualDuplicateNum = findDuplicateNum(new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 13, // 13 is duplicate
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50
        });
        assertEquals(13, actualDuplicateNum);
    }
}
