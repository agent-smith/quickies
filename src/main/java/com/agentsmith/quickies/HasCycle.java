package com.agentsmith.quickies;

/**
 * Floyd's "tortoise and hare" cycle-finding algo, which uses a slow and fast pointer to traverse the Nodes. If they
 * ever meet, then there's a cycle, and if either ever hits null, then there's no cycle since that means there's an end.
 * <p/>
 * User: rmarquez
 * Date: 2/1/2014
 * Time: 15:40
 */
public class HasCycle
{
    public static <E> boolean hasCycle(Node<E> node)
    {
        if (node == null) return false;

        Node<E> turtle = node;
        Node<E> rabbit = node;

        while (true)
        {
            if (turtle == null || rabbit == null) return false;

            turtle = turtle.nextNode; // move 1 node at a time

            if (rabbit.nextNode == null) return false;

            rabbit = rabbit.nextNode.nextNode; // move 2 nodes at a time

            if (turtle == rabbit) return true;
        }
    }

    public static <E> boolean hasCycleAlternative(Node<E> node)
    {
        if (node == null || node.nextNode == null) return false;

        Node<E> prev = null;
        Node<E> curr = node;
        Node<E> next;
        while (curr != null)
        {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        boolean hasCycle = (prev == node);

        curr = prev;
        prev = null;
        while (curr != null)
        {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        return hasCycle;
    }
}
