package pers.vay;

import pers.vay.structure.ListNode;
import pers.vay.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        res.add(root.val);
        while (true) {
            List<TreeNode> temps = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    temps.add(node.left);
                }
                if (node.right != null) {
                    temps.add(node.right);
                }
            }
            if (temps.size() == 0) {
                break;
            }
            res.add(temps.get(temps.size() - 1).val);
            nodes = temps;
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> sums = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
        }
        List<TreeNode> nodes = new ArrayList<>();
        while (!roots.isEmpty()) {
            for (int i = 0; i < roots.size(); i++) {
                if (roots.get(i).left != null) {
                    nodes.add(roots.get(i).left);
                }
                if (roots.get(i).right != null) {
                    nodes.add(roots.get(i).right);
                }
            }
            sums.add(roots);
            roots = nodes;
            nodes = new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        for (List<TreeNode> nodes1 : sums) {
            List<Integer> rr = new ArrayList<>();
            if (flag) {
                for (int i = nodes1.size() - 1; i >= 0; i--) {
                    rr.add(nodes1.get(i).val);
                }
            } else {
                for (int i = 0; i < nodes1.size(); i++) {
                    rr.add(nodes1.get(i).val);
                }
            }
            flag ^= true;
            res.add(rr);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        BFS b = new BFS();
        b.levelOrder(node);
    }

}
