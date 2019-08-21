package linked_list.tree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TreeSolutionTest {

    TreeSolution solution = new TreeSolution();

    @Test
    public void inorderTraversal() {
        TreeNode root = getRoot();
        List<Integer> res = getRes();
        Assert.assertEquals(res, solution.inorderTraversalRecursive(root));
    }

    @Test
    public void inorderTraversalNonRecursive() {
        TreeNode root = getRoot();
        List<Integer> res = getRes();
        Assert.assertEquals(res, solution.inorderTraversalNonRecursive(root));
    }

    @Test
    public void preorderTraversalRecursive() {
        TreeNode root = getRoot();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        Assert.assertEquals(res, solution.preorderTraversalRecursive(root));
    }

    @Test
    public void preorderTraversalNonRecursive() {
        TreeNode root = getRoot();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        Assert.assertEquals(res, solution.preorderTraversalNonRecursive(root));
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
        List<Integer> res = new ArrayList<>();
        res.add(3);
        res.add(2);
        res.add(1);
        Assert.assertEquals(res, solution.postorderTraversalRecursive(root));
    }

}