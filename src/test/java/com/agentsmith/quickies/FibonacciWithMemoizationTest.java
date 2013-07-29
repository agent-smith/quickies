package com.agentsmith.quickies;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FibonacciWithMemoization.  Basically, finding fibonacci number, given n.
 * <p/>
 * Source for the first 1001 FibonacciWithMemoization Numbers: http://ibiblio.org/pub/docs/books/gutenberg/etext01/fbncc10.txt
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 2:00 PM
 */
public class FibonacciWithMemoizationTest
{
    @Test
    public void fib0() throws Exception
    {
        BigInteger actual = runFib(0);
        assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void fib1() throws Exception
    {
        BigInteger actual = runFib(1);
        assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void fib2() throws Exception
    {
        BigInteger actual = runFib(2);
        assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void fib3() throws Exception
    {
        BigInteger actual = runFib(3);
        assertEquals(BigInteger.valueOf(2), actual);
    }

    @Test
    public void fib35() throws Exception
    {
        BigInteger actual = runFib(35);
        assertEquals(BigInteger.valueOf(9227465), actual);
    }

    @Test
    public void fib40() throws Exception
    {
        BigInteger actual = runFib(40);
        assertEquals(BigInteger.valueOf(102334155), actual);
    }

    @Test
    public void fib100() throws Exception
    {
        BigInteger actual = runFib(100);
        assertEquals(new BigInteger("354224848179261915075"), actual);
    }

    @Test
    public void fib1000() throws Exception
    {
        BigInteger actual = runFib(1000);
        assertEquals(new BigInteger("4346655768693745643568852767504062580256466051737178040248172908953655541794"+
                                            "9051890403879840079255169295922593080322634775209689623239873322471161642996"+
                                            "440906533187938298969649928516003704476137795166849228875"), actual);
    }

    private BigInteger runFib(long n)
    {
        FibonacciWithMemoization f = new FibonacciWithMemoization();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        BigInteger actual = f.calcFib(BigInteger.valueOf(n));
        stopWatch.stop();

        System.out.println("Took this long to find fibonacci # for n="+n+": "+stopWatch.toString());
        return actual;
    }
}
