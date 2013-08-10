package com.agentsmith.quickies;

/**
 * Given N nodes, find the middle one.
 * <p/>
 * Basically, use two pointers and advance one pointer every time and the other pointer every other time.  Then, when
 * the furthest pointer has reached the end, the other pointer is in the middle.
 * <p/>
 * User: rmarquez
 * Date: 7/27/13
 * Time: 11:35 PM
 */
public class FindMiddleNode<E>
{
    public Node<E> findMiddle(Node<E> node)
    {
        if (node == null)
        {
            return null;
        }

        if (node.nextNode == null)
        {
            return node;
        }

        Node<E> first = node;
        Node<E> second = node.nextNode;

        int i = 0;
        while (second != null)
        {
            if (++i % 2 == 0)
            {
                first = first.nextNode;
            }

            second = second.nextNode;
        }

        return first;
    }

    public static void main(String[] args)
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", new Node<>("E", null)))));

        System.out.println("Finding middle node of: " + node);

        FindMiddleNode<String> f = new FindMiddleNode<>();
        Node<String> midNode = f.findMiddle(node);

        System.out.println("Middle node: " + midNode);
    }
}
