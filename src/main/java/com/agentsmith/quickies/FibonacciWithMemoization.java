package com.agentsmith.quickies;

import java.math.BigInteger;
import java.util.ArrayList;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Calculate each fibonacci number once (linear).
 * Recursive calls just return the previous cached ones in constant time.
 */
public class FibonacciWithMemoization
{
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private final ArrayList<BigInteger> memo = new ArrayList<>();

    public FibonacciWithMemoization()
    {
        memo.add(ZERO);
        memo.add(ONE);
    }

    public BigInteger calcFib(BigInteger n)
    {
        // If we haven't seen the fib number before, then calculate it.
        if (n.intValue() >= memo.size())
        {
            BigInteger f_nMinusOne = calcFib(n.subtract(ONE));
            BigInteger f_nMinusTwo = calcFib(n.subtract(TWO));
            memo.add(n.intValue(), f_nMinusOne.add(f_nMinusTwo));
        }

        // Otherwise, just return it.
        return memo.get(n.intValue());
    }

    public static void main(String[] args)
    {
        BigInteger n = new BigInteger(args[0]);

        System.out.println("Finding the fibonacci number, given n="+n);

        FibonacciWithMemoization fibWithMem = new FibonacciWithMemoization();
        BigInteger nFib = fibWithMem.calcFib(n);

        System.out.println("Fibonacci number for n="+n+": "+nFib);
    }
}
