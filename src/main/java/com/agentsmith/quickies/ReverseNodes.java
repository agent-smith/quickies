package com.agentsmith.quickies;

/**
 * Reversing a linked list.
 * <p/>
 * User: rmarquez
 * Date: 7/27/13
 * Time: 11:35 PM
 */
public class ReverseNodes
{
    public static <E> Node<E> reverseRecursive(Node<E> node)
    {
        if (node == null || node.nextNode == null) return node;

        // copy the next node
        // (e.g. if node = A->B->C->null, then nextNode = B->C->null)
        Node<E> nextNode = node.nextNode;

        // unlink the next node
        // (e.g. if node = A->B->C->null, then node.nextNode = B->null)
        node.nextNode = null;

        // pass the copy of the next node to the recursive call
        // (e.g. nextNode = B->C->null)
        Node<E> reverse = reverseRecursive(nextNode);

        // link the copy of the next node's next node to the current node
        // (e.g. if reverseRecursive = C->B->null, then nextNode.nextNode = C->B->A->null)
        nextNode.nextNode = node;

        return reverse;
    }

    public static <E> Node<E> reverseRecursiveSimple(Node<E> node)
    {
        return doReverseRecursiveSimple(null, node);
    }

    private static <E> Node<E> doReverseRecursiveSimple(Node<E> prev, Node<E> curr)
    {
        if (curr == null) return curr;

        Node<E> next = curr.nextNode;
        curr.nextNode = prev;

        if (next != null) return doReverseRecursiveSimple(curr, next);
        return curr;
    }

    public static <E> Node<E> reverseIterative(Node<E> node)
    {
        if (node == null || node.nextNode == null) return node;

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

        return prev;
    }

    public static void main(String[] args)
    {
        Node<String> nodes = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        System.out.println("Reversing nodes recursively: " + nodes);
        Node<String> reversedNodes = ReverseNodes.reverseRecursive(nodes);
        System.out.println("Recursively Reversed: " + reversedNodes);

        nodes = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        System.out.println("\nReversing nodes recursively (simple version): " + nodes);
        reversedNodes = ReverseNodes.reverseRecursiveSimple(nodes);
        System.out.println("Recursively Reversed (simple version): " + reversedNodes);

        nodes = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        System.out.println("\nReversing nodes iteratively: " + nodes);
        reversedNodes = ReverseNodes.reverseIterative(nodes);
        System.out.println("Iteratively Reversed: " + reversedNodes);
    }
}
