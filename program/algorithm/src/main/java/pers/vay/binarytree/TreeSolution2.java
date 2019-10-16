package pers.vay.binarytree;

import pers.vay.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author qiaozhe
 */
public class TreeSolution2 {

    public List<Integer> preDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper1(root, res);
        return res;
    }

    private void helper1(TreeNode root, List<Integer> res) {
        if (root.left == root.right) {
            res.add(root.val);
            return;
        }
        res.add(root.val);
        helper1(root.left, res);
        helper1(root.right, res);
    }

    public List<Integer> preXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        res.add(root.val);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(root.left);
            }
            if (node.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }

    public List<Integer> inDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper2(res, root);
        return res;
    }

    private void helper2(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        helper2(res, root.left);
        res.add(root.val);
        helper2(res, root.right);
    }

    public List<Integer> inXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root != null && !stack.empty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }

    public List<Integer> postDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper3(res, root);
        return res;
    }

    private void helper3(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        helper3(res, root);
        helper3(res, root);
        res.add(root.val);
    }

    public List<Integer> postXh(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

}
