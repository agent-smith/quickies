package com.agentsmith.quickies;

/**
 * Simple Node, containing a value, and a link to a left and right child Node.
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 12:15 AM
 */
public class TreeNode<KEY, VAL>
{
    TreeNode<KEY, VAL> left;
    TreeNode<KEY, VAL> right;
    KEY key;
    VAL value;

    TreeNode(KEY key, VAL value, TreeNode<KEY, VAL> left, TreeNode<KEY, VAL> right)
    {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return doToString(1);
    }

    public String doToString(int level) {

        StringBuilder spacesSB = new StringBuilder();
        for (int i = 0; i < level; i++) {
            spacesSB.append("     ");
        }
        String spaces = spacesSB.toString();

        if (left == null && right == null)
        {
            return "Node{" + value + ",\n" +
                    spaces + "left=null,\n" +
                    spaces + "right=null\n" +
                    spaces + "}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Node{")
                .append(value).append(",\n")
                .append(spaces).append("left=").append((left == null) ? "null" : left.doToString(level+2)).append(",\n")
                .append(spaces).append("right=").append((right == null) ? "null" : right.doToString(level+2)).append(
                "\n")
                .append(spaces).append("}");

        return sb.toString();
    }
}
