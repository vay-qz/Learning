package pers.vay.binarytree;

import com.google.common.collect.Lists;
import pers.vay.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree2 {

    public void preorder_dg(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            System.out.print(" ");
        }
        if (root.left != null) {
            preorder_dg(root.left);
        }
        if (root.right != null) {
            preorder_dg(root.right);
        }
    }

    public void inorder_dg(TreeNode root) {
        if (root.left != null) {
            inorder_dg(root.left);
        }
        System.out.print(root.val);
        System.out.print(" ");
        if (root.right != null) {
            inorder_dg(root.right);
        }
    }

    public void postorder_dg(TreeNode root) {
        if (root.left != null) {
            postorder_dg(root.left);
        }
        if (root.right != null) {
            postorder_dg(root.right);
        }
        System.out.print(root.val);
        System.out.print(" ");
    }

    public void preorder_xh (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root != null && !stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val);
            System.out.print(" ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public void inorder_xh (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val);
            System.out.print(" ");
            root = root.right;
        }
    }

    public void postorder_xh (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        stack.push(root);
        while (root != null && !stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!res.isEmpty()) {
            int treeNode = res.pop();
            System.out.print(treeNode);
            System.out.print(" ");
        }
    }

//    public static void main(String[] args) {
//        BinaryTree2 tree = new BinaryTree2();
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        node.right.left = new TreeNode(5);
//        tree.inorder_dg(node);
//        System.out.println();
//        tree.preorder_dg(node);
//        System.out.println();
//        tree.postorder_dg(node);
//        System.out.println();
//        tree.preorder_xh(node);
//        System.out.println();
//        tree.inorder_xh(node);
//        System.out.println();
//        tree.postorder_xh(node);
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> source = new ArrayList<>();
        for (int i : nums) {
            source.add(i);
        }
        for(int i = 0; i < source.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(source.get(i));
            List<Integer> nextSource = getSourceExceptIndex(source, i);
            getRes(res, temp, nextSource);
        }
        return res;
    }

    private void getRes(List<List<Integer>> res, List<Integer> temp, List<Integer> source) {
        if (source.size() == 0) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            List<Integer> nextRes = copy(temp);
            nextRes.add(source.get(i));
            List<Integer> nextSource = getSourceExceptIndex(source, i);
            getRes(res, nextRes, nextSource);
        }
    }

    private List<Integer> copy(List<Integer> temp) {
        List<Integer> res = new ArrayList<>();
        for (int i : temp) {
            res.add(i);
        }
        return res;
    }

    private List<Integer> getSourceExceptIndex(List<Integer> source, int index) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (i != index) {
                res.add(source.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree2 tree2 = new BinaryTree2();
        int[] nums = {1,1,3};
        List<List<Integer>> res = tree2.permute(nums);
        System.out.println(res);
        List<List<Integer>> res2 = tree2.permuteUnique(nums);
        System.out.println(res2);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> source = new ArrayList<>();
        for (int i : nums) {
            source.add(i);
        }
        source.sort((a,b)->{
            if (a < b) {
                return 1;
            }
            return -1;
        });
        for(int i = 0; i < source.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            if (i > 0 && source.get(i).equals(source.get(i - 1))) {
                continue;
            }
            temp.add(source.get(i));
            List<Integer> nextSource = getSourceExceptIndex(source, i);
            getRes2(res, temp, nextSource);
        }
        return res;
    }

    private void getRes2(List<List<Integer>> res, List<Integer> temp, List<Integer> source) {
        if (source.size() == 0) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            if (i > 0 && source.get(i).equals(source.get(i - 1))) {
                continue;
            }
            List<Integer> nextRes = copy(temp);
            nextRes.add(source.get(i));
            List<Integer> nextSource = getSourceExceptIndex(source, i);
            getRes2(res, nextRes, nextSource);
        }
    }



}
