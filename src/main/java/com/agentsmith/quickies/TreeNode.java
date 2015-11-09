package com.agentsmith.quickies;

import static java.lang.String.format;

/**
 * A Node in a Tree, containing a reference to its parent, a key and value,
 * and a link to left and right child Tree Nodes.
 * <p/>
 * User: rmarquez
 * Date: 7/28/13
 * Time: 12:15 AM
 */
public class TreeNode<KEY extends Comparable<KEY>, VAL>
{
    TreeNode<KEY, VAL> parent;

    TreeNode<KEY, VAL> left;
    TreeNode<KEY, VAL> right;

    KEY key;
    VAL value;

    TreeNode(TreeNode<KEY, VAL> parent, KEY key, VAL value) {
        this(parent, key, value, null, null);
    }

    TreeNode(KEY key, VAL value, TreeNode<KEY, VAL> left, TreeNode<KEY, VAL> right) {
        this(null, key, value, left, right);
    }

    TreeNode(TreeNode<KEY, VAL> parent, KEY key, VAL value, TreeNode<KEY, VAL> left, TreeNode<KEY, VAL> right) {
        this.parent = parent;
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
            return format("Node{%s,\n%sleft=null,\n%sright=null\n%s}",
                    value, spaces, spaces, spaces);
        }

        return format("Node {%s,\n%sleft=%s,\n%sright=%s\n%s}",
                value, spaces,
                (left == null) ? "null" : left.doToString(level + 2), spaces,
                (right == null) ? "null" : right.doToString(level + 2), spaces);
    }
}
