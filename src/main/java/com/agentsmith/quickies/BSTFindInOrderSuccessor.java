package com.agentsmith.quickies;

/**
 * Note that in-order-traversal is: left-most node first, then parent of left-most node, then right child of parent, etc.
 *
 * Example:
 *
 * Given BST of 3 nodes A,B,C.
 *
 * When B is the root.
 * And A is the left child of B.
 * And C is the right child of B.
 *
 * Then, the in-order-traversal is A,B,C.
 * And the in-order-successor of A is B.
 * And the in-order-successor of B is C.
 * And the in-order-successor of C is null.
 *
 * Created by agentsmith on 2015-11-08.
 */
public class BSTFindInOrderSuccessor {

    public static TreeNode findInOrderSuccessor(TreeNode n) {
        return findInOrderSuccessor(n, false);
    }

    public static TreeNode findInOrderSuccessor(TreeNode n, boolean movingUp) {
        if (n == null) {
            return null;
        }

        if (n.right != null && !movingUp) {
            return leftMostNode(n.right);
        }

        TreeNode parent = n.parent;
        if (parent == null) {
            return null;
        } else if (parent.left == n) {
            return parent;
        }

        return findInOrderSuccessor(parent, true);
    }

    private static TreeNode leftMostNode(TreeNode n) {
        if (n == null) return null;
        if (n.left == null) return n;
        return leftMostNode(n.left);
    }
}
