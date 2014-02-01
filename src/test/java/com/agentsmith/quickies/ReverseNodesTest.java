package com.agentsmith.quickies;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for ReverseNodes.
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 1:35 AM
 */
public class ReverseNodesTest
{
    // Recursive tests

    @Test
    public void reverseRecursive_NullNode()
    {
        Node<String> node = null;

        Node<String> actual = ReverseNodes.reverseRecursive(node);
        assertNull(actual);
    }

    @Test
    public void reverseRecursive_OneNode()
    {
        Node<String> node = new Node<>("A", null);

        Node<String> actual = ReverseNodes.reverseRecursive(node);
        assertEquals(new Node<>("A", null), actual);
    }

    @Test
    public void reverseRecursive_TwoNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", null));

        Node<String> actual = ReverseNodes.reverseRecursive(node);
        assertEquals(new Node<>("B", new Node<>("A", null)), actual);
    }

    @Test
    public void reverseRecursive_ThreeNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", null)));

        Node<String> actual = ReverseNodes.reverseRecursive(node);
        assertEquals(new Node<>("C", new Node<>("B", new Node<>("A", null))), actual);
    }

    @Test
    public void reverseRecursive_FourNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        Node<String> actual = ReverseNodes.reverseRecursive(node);
        assertEquals(new Node<>("D", new Node<>("C", new Node<>("B", new Node<>("A", null)))), actual);
    }

    // Iterative tests

    @Test
    public void reverseIterative_NullNode()
    {
        Node<String> node = null;

        Node<String> actual = ReverseNodes.reverseIterative(node);
        assertNull(actual);
    }

    @Test
    public void reverseIterative_OneNode()
    {
        Node<String> node = new Node<>("A", null);

        Node<String> actual = ReverseNodes.reverseIterative(node);
        assertEquals(new Node<>("A", null), actual);
    }

    @Test
    public void reverseIterative_TwoNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", null));

        Node<String> actual = ReverseNodes.reverseIterative(node);
        assertEquals(new Node<>("B", new Node<>("A", null)), actual);
    }

    @Test
    public void reverseIterative_ThreeNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", null)));

        Node<String> actual = ReverseNodes.reverseIterative(node);
        assertEquals(new Node<>("C", new Node<>("B", new Node<>("A", null))), actual);
    }

    @Test
    public void reverseIterative_FourNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        Node<String> actual = ReverseNodes.reverseIterative(node);
        assertEquals(new Node<>("D", new Node<>("C", new Node<>("B", new Node<>("A", null)))), actual);
    }
}
