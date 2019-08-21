package linked_list.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeSolution {

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getzx(res, root);
        return res;
    }

    public List<Integer> inorderTraversalNonRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !tmp.empty()) {
            while(cur != null) {
                tmp.push(cur);
                cur = cur.left;
            }
            cur = tmp.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    private void getzx(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return ;
        }
        if(root.left != null) {
            getzx(res, root.left);
        }
        res.add(root.val);
        if(root.right != null) {
            getzx(res, root.right);
        }
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getqx(res, root);
        return res;
    }

    private void getqx(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        res.add(root.val);
        if(root.left!=null) {
            getqx(res, root.left);
        }
        if(root.right != null) {
            getqx(res, root.right);
        }
    }

    public List<Integer> preorderTraversalNonRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        gethx(res, root);
        return res;
    }

    private void gethx(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if(root.left != null) {
            gethx(res, root.left);
        }
        if(root.right != null) {
            gethx(res, root.right);
        }
        res.add(root.val);
    }

    public List<Integer> postorderTraversalNonRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right  != null) {
               stack.push(node.right);
            }

        }
        return res;
    }

}
