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
    @Test
    public void reverseNullNode()
    {
        Node<String> node = null;

        ReverseNodes rll = new ReverseNodes();
        Node<String> actual = rll.reverse(node);
        assertNull(actual);
    }

    @Test
    public void reverseOneNode()
    {
        Node<String> node = new Node<>("A", null);

        ReverseNodes rll = new ReverseNodes();
        Node<String> actual = rll.reverse(node);
        assertEquals(new Node<>("A", null), actual);
    }

    @Test
    public void reverseTwoNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", null));

        ReverseNodes rll = new ReverseNodes();
        Node<String> actual = rll.reverse(node);
        assertEquals(new Node<>("B", new Node<>("A", null)), actual);
    }

    @Test
    public void reverseThreeNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", null)));

        ReverseNodes rll = new ReverseNodes();
        Node<String> actual = rll.reverse(node);
        assertEquals(new Node<>("C", new Node<>("B", new Node<>("A", null))), actual);
    }

    @Test
    public void reverseFourNodes()
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        ReverseNodes rll = new ReverseNodes();
        Node<String> actual = rll.reverse(node);
        assertEquals(new Node<>("D", new Node<>("C", new Node<>("B", new Node<>("A", null)))), actual);
    }
}
