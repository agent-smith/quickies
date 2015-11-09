package com.agentsmith.quickies;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for BSTFindCommonAncestor.
 *
 * Created by agentsmith on 2015-11-08.
 */
public class BSTFindCommonAncestorTest {

    @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
    @Test
    public void testFindCommonAncestor() throws Exception {
        /*
                     H
                   /   \
                  C     J
                 / \     \
                A  F      N
                  / \    /
                 D  G   M
         */

        TreeNode<Integer, String> H = new TreeNode<>(null, 8, "H", null, null);

        // left side of H

        TreeNode C = new TreeNode(H, 3, "C");
        H.left = C;

        TreeNode A = new TreeNode<>(C, 1, "A");
        C.left = A;
        TreeNode F = new TreeNode<>(C, 6, "F");
        C.right = F;

        TreeNode D = new TreeNode<>(F, 4, "D");
        F.left = D;
        TreeNode G = new TreeNode<>(F, 7, "G");
        F.right = G;

        // right side of H

        TreeNode J = new TreeNode(H, 10, "J");
        H.right = J;

        TreeNode N = new TreeNode<>(J, 14, "N");
        J.right = N;

        TreeNode M = new TreeNode<>(N, 13, "M");
        N.left = M;

        BSTFindCommonAncestor BSTFindCommonAncestor = new BSTFindCommonAncestor(H);

        assertEquals(C, BSTFindCommonAncestor.findCommonAncestor(A, G));
        assertEquals(H, BSTFindCommonAncestor.findCommonAncestor(A, N));
        assertEquals(H, BSTFindCommonAncestor.findCommonAncestor(C, J));
        assertEquals(J, BSTFindCommonAncestor.findCommonAncestor(M, N));
        assertEquals(null, BSTFindCommonAncestor.findCommonAncestor(H, N));
        assertEquals(null, BSTFindCommonAncestor.findCommonAncestor(A, H));
    }
}