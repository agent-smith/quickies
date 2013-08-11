package com.agentsmith.quickies;

/**
 * Insert/delete element into/from a binary tree.  i.e. insert and delete impl for BST
 * <p/>
 * User: rmarquez
 * Date: 8/10/13
 * Time: 9:38 PM
 */
public class BSTInsertAndDelete<KEY extends Comparable<KEY>, VAL>
{
    private TreeNode<KEY, VAL> root;

    public BSTInsertAndDelete(TreeNode<KEY, VAL> root) {
        this.root = root;
    }

    public TreeNode<KEY, VAL> insert(KEY key, VAL val) {
        return insert(root, key, val);
    }

    public TreeNode<KEY, VAL> insert(TreeNode<KEY, VAL> node, KEY key, VAL val) {
        if (node == null) {
            return new TreeNode<>(key, val, null, null);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, val);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, val);
        } else {
            node.value = val;
        }

        return node;
    }

    public TreeNode<KEY, VAL> remove(KEY key) {
        return remove(root, key);
    }

    public TreeNode<KEY, VAL> remove(TreeNode<KEY, VAL> node, KEY key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            TreeNode<KEY, VAL> temp = node;

            // Pulls the right child upward
            node = min(temp.right);
            node.left = deleteMin(temp.right);
            node.left = temp.left;

            // OR... could do this - it's the same thing, but pulls the left child upward
            // node = max(temp.left);
            // node.right = deleteMax(temp.left);
            // node.right = temp.right;
        }

        return node;
    }

    private TreeNode<KEY, VAL> min(TreeNode<KEY, VAL> node)
    {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode<KEY, VAL> deleteMin(TreeNode<KEY, VAL> node)
    {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private TreeNode<KEY, VAL> max(TreeNode<KEY, VAL> node)
    {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    private TreeNode<KEY, VAL> deleteMax(TreeNode<KEY, VAL> node)
    {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    public static void main(String[] args)
    {
        TreeNode<Integer, String> tree =
                new TreeNode<>(8, "H",
                               new TreeNode<>(3, "C",
                                              new TreeNode<>(1, "A", null, null),
                                              new TreeNode<>(6, "F",
                                                             new TreeNode<>(4, "D", null, null),
                                                             new TreeNode<>(7, "G", null, null))),
                               new TreeNode<>(10, "J",
                                              null,
                                              new TreeNode<>(14, "N",
                                                             new TreeNode<>(13, "M", null, null),
                                                             null)));

        System.out.println("Inserting 'E' into following tree:\n" + tree);
        BSTInsertAndDelete<Integer, String> f1 = new BSTInsertAndDelete<>(tree);
        TreeNode<Integer, String> result1 = f1.insert(5, "E");
        System.out.println("Resulting tree:\n" + result1);

        System.out.println("\n\nRemoving 'E' (which has no children) from following tree:\n" + tree);
        BSTInsertAndDelete<Integer, String> f2 = new BSTInsertAndDelete<>(result1);
        TreeNode<Integer, String> result2 = f2.remove(5);
        System.out.println("Resulting tree:\n" + result2);

        System.out.println("Removing 'N' (which has 1 child) from following tree:\n" + tree);
        BSTInsertAndDelete<Integer, String> f3 = new BSTInsertAndDelete<>(result2);
        TreeNode<Integer, String> result3 = f3.remove(14);
        System.out.println("Resulting tree:\n" + result3);

        System.out.println("\n\nRemoving 'F' (which has 2 children) from following tree:\n" + tree);
        BSTInsertAndDelete<Integer, String> f4 = new BSTInsertAndDelete<>(result3);
        TreeNode<Integer, String> result4 = f4.remove(6);
        System.out.println("Resulting tree:\n" + result4);
    }
}
