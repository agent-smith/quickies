package com.agentsmith.quickies;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FindMiddleNode.
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 11:45 PM
 */
public class FindMiddleNodeTest
{
    @Test
    public void findMiddleForNullNode()
    {
        Node<String> node = null;

        FindMiddleNode<String> f = new FindMiddleNode<>();
        Node<String> actual = f.findMiddle(node);
        assertNull(actual);
    }

    @Test
    public void findMiddleForOneNode()
    {
        Node<String> node = new Node<>("A", null);

        FindMiddleNode<String> f = new FindMiddleNode<>();
        Node<String> actual = f.findMiddle(node);
        assertEquals("A", actual.value);
    }

    @Test
    public void findMiddleForEvenNumNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        FindMiddleNode<String> f = new FindMiddleNode<>();
        Node<String> actual = f.findMiddle(node);
        assertEquals("B", actual.value);
    }

    @Test
    public void findMiddleForOddNumNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", new Node<>("E", null)))));

        FindMiddleNode<String> f = new FindMiddleNode<>();
        Node<String> actual = f.findMiddle(node);
        assertEquals("C", actual.value);
    }
}
