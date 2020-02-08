package pers.vay.binarytree;

import org.junit.jupiter.api.Test;
import pers.vay.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeSolutionTest {

    TreeSolution solution = new TreeSolution();

    @Test
    public void inorderTraversal() {
        TreeNode root = getRoot();
        List<Integer> res = getRes();
        assertEquals(res, solution.inDg(root));
        assertEquals(res, solution.inXh(root));
    }

    @Test
    public void preorderTraversal() {
        TreeNode root = getRoot();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        assertEquals(res, solution.preDg(root));
        assertEquals(res, solution.preXh(root));
    }

    private List<Integer> getRes() {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(3);
        res.add(2);
        return res;
    }

    TreeNode getRoot() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    @Test
    public void postorderTraversal() {
        TreeNode root = getRoot();
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
//        assertEquals(res, solution.postDg(root));
        assertEquals(res, solution.postXh(root2));
    }

    @Test
    public void maxDepth() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertEquals(solution.maxDepth(root), 3);
    }

    @Test
    public void isBalanced() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertEquals(solution.isBalanced(root), false);
    }

    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        assertEquals(solution.isValidBST(root), false);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        assertEquals(solution.isValidBST(root2), true);
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        assertEquals(solution.isValidBST(root3), false);
    }

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);
        root.right.left.right = new TreeNode(6);
        System.out.println(solution.zigzagLevelOrder(root));
    }

}