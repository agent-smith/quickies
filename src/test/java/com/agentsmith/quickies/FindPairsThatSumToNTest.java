package com.agentsmith.quickies;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FindPairsThatSumToN.
 * <p/>
 * User: rmarquez
 * Date: 8/3/13
 * Time: 5:28 PM
 */
public class FindPairsThatSumToNTest
{
    private final int N = 10;
    private final int[] EXPECTED = new int[] { 10, -5, 20, 0, -10 };
    private static Map<Integer, Integer> EXPECTED_PAIRS = new HashMap<>();

    @BeforeClass
    public static void popExpectedMap()
    {
        EXPECTED_PAIRS.put(0, 10);
        EXPECTED_PAIRS.put(-10, 20);
    }

    @Test
    public void findPairsNoSort() throws Exception
    {
        FindPairsThatSumToN f = new FindPairsThatSumToN();
        Map<Integer, Integer> actual = f.findPairsNoSort(EXPECTED, N);
        assertEquals(EXPECTED_PAIRS, actual);
    }

    @Test
    public void findPairsSort() throws Exception
    {
        FindPairsThatSumToN f = new FindPairsThatSumToN();
        Map<Integer, Integer> actual = f.findPairsNoSort(EXPECTED, N);
        assertEquals(EXPECTED_PAIRS, actual);
    }

    @Test
    public void pairsFromBothApproachesEqual() throws Exception
    {
        FindPairsThatSumToN f1 = new FindPairsThatSumToN();
        FindPairsThatSumToN f2 = new FindPairsThatSumToN();
        assertEquals(f1.findPairsNoSort(EXPECTED, N), f2.findPairsNoSort(EXPECTED, N));
    }
}
