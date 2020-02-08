package pers.vay;

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
}
