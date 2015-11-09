package com.agentsmith.quickies;

/**
 * Given a BST, and 2 nodes, find their common ancestor.
 *
 * Created by agentsmith on 2015-11-08.
 */
public class BSTFindCommonAncestor {

    private TreeNode root;

    public BSTFindCommonAncestor(TreeNode root) {
        this.root = root;
    }

    public TreeNode findCommonAncestor(TreeNode node1, TreeNode node2) {
        return (root == null || node1 == null || node2 == null)
                ? null
                : doFindCommonAncestor(root, node1, node2);
    }

    @SuppressWarnings("unchecked")
    private TreeNode doFindCommonAncestor(TreeNode node, TreeNode node1, TreeNode node2) {

        int cmpNode1 = node1.key.compareTo(node.key);
        int cmpNode2 = node2.key.compareTo(node.key);

        if (cmpNode1 == 0 || cmpNode2 == 0) {
            return node.parent;
        }

        if (cmpNode1 != cmpNode2) {
            return node;
        }

        if (cmpNode1 < 0) { // && cmpNode2 < 0
            node = doFindCommonAncestor(node.left, node1, node2);
        } else if (cmpNode1 > 0) { // && cmpNode2 > 0
            node = doFindCommonAncestor(node.right, node1, node2);
        }

        return node;
    }
}
