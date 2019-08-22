package linked_list.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeSolution {

    public List<Integer> preDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preRes(res, root);
        return res;
    }

    private void preRes(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            preRes(res, root.left);
        }
        if (root.right != null) {
            preRes(res, root.right);
        }
    }

    public List<Integer> inDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inRes(res, root);
        return res;
    }

    private void inRes(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if(root.left != null) {
            inRes(res, root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inRes(res, root.right);
        }
    }

    public List<Integer> postDg (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postRes(res, root);
        return res;
    }

    private void postRes(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            postRes(res, root.left);
        }
        if (root.right != null) {
            postRes(res, root.right);
        }
        res.add(root.val);
    }

    public List<Integer> preXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public List<Integer> inXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.empty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> postXh(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            //每次找出后序遍历的最后一个
            root = stack.pop();
            res.addFirst(root.val);
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

}
