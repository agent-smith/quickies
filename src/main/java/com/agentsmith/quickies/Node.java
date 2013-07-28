package com.agentsmith.quickies;

/**
 * Simple Node, containing a link to the next node and a value.
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 12:15 AM
 */
public class Node<E>
{
    Node<E> nextNode;
    E value;

    Node(E value, Node<E> nextNode)
    {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Node node = (Node) o;

        if (nextNode != null ? !nextNode.equals(node.nextNode) : node.nextNode != null)
        {
            return false;
        }
        if (value != null ? !value.equals(node.value) : node.value != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = nextNode != null ? nextNode.hashCode() : 0;
        result = 31*result+(value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        if (nextNode == null)
        {
            return "Node{" + value + ", null}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Node{").append(value).append(", ").append(nextNode).append('}');

        return sb.toString();
    }
}
