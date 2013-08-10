package com.agentsmith.quickies;

/**
 * Reversing a linked list.
 * <p/>
 * User: rmarquez
 * Date: 7/27/13
 * Time: 11:35 PM
 */
public class ReverseNodes<E>
{
    public Node<E> reverse(Node<E> node)
    {
        if (node == null)
        {
            return null;
        }

        if (node.nextNode == null)
        {
            return node;
        }

        // copy the next node
        // (e.g. if node = A->B->C->null, then nextNode = B->C->null)
        Node<E> nextNode = node.nextNode;

        // unlink the next node
        // (e.g. if node = A->B->C->null, then node.nextNode = B->null)
        node.nextNode = null;

        // pass the copy of the next node to the recursive call
        // (e.g. nextNode = B->C->null)
        Node<E> reverse = reverse(nextNode);

        // link the copy of the next node's next node to the current node
        // (e.g. if reverse = C->B->null, then nextNode.nextNode = C->B->A->null)
        nextNode.nextNode = node;

        return reverse;
    }

    public static void main(String[] args)
    {
        Node<String> node = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        System.out.println("Reversing: "+node);

        ReverseNodes<String> rll = new ReverseNodes<>();
        Node<String> reversedNodes = rll.reverse(node);

        System.out.println("Reversed: "+reversedNodes);
    }
}
