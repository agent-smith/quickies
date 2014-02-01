package com.agentsmith.quickies;

import org.junit.Test;

import static com.agentsmith.quickies.HasCycle.hasCycle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for HasCycle.
 * <p/>
 * User: rmarquez
 * Date: 2/1/2014
 * Time: 15:47
 */
public class HasCycleTest
{
    private final static Node<String> A = new Node<>("A", null);
    private final static Node<String> B = new Node<>("B", null);
    private final static Node<String> C = new Node<>("C", null);
    private final static Node<String> D = new Node<>("D", null);
    private final static Node<String> E = new Node<>("E", null);

    @Test
    public void hasNoCycleForNullNode()
    {
        Node<String> node = null;
        assertFalse(hasCycle(node));
    }

    @Test
    public void hasNoCycleForOneNode()
    {
        assertFalse(hasCycle(A));
    }

    @Test
    public void hasCycleForOneNode()
    {
        A.nextNode = A;
        assertTrue(hasCycle(A));
    }

    @Test
    public void hasNoCycleForEvenNumNodes()
    {
        C.nextNode = D;
        B.nextNode = C;
        A.nextNode = B;

        assertFalse(hasCycle(D));
    }

    @Test
    public void hasCycleForEvenNumNodes_DtoB()
    {
        C.nextNode = D;
        B.nextNode = C;
        A.nextNode = B;

        D.nextNode = B; // cycle from D -> B

        assertTrue(hasCycle(D));
    }

    @Test
    public void hasNoCycleForOddNumNodes()
    {
        D.nextNode = E;
        C.nextNode = D;
        B.nextNode = C;
        A.nextNode = B;

        assertFalse(hasCycle(E));
    }

    @Test
    public void hasCycleForOddNumNodes_EtoB()
    {
        D.nextNode = E;
        C.nextNode = D;
        B.nextNode = C;
        A.nextNode = B;

        E.nextNode = B; // cycle from E -> B

        assertTrue(hasCycle(E));
    }
}
