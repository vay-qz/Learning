package pers.vay.binarytree;

import pers.vay.structure.TreeNode;

import java.util.Stack;

public class BinaryTree {

    public void inorder(TreeNode treeNode) {
        if (treeNode.left != null) {
            inorder(treeNode.left);
        }
        System.out.print(treeNode.val);
        System.out.print(" ");
        if (treeNode.right != null) {
            inorder(treeNode.right);
        }
    }
    
    public void preorder(TreeNode treeNode) {
        System.out.print(treeNode.val);
        System.out.print(" ");
        if (treeNode.left != null) {
            preorder(treeNode.left);
        }
        if (treeNode.right != null) {
            preorder(treeNode.right);
        }
    }

    public void postorder(TreeNode treeNode) {
        if (treeNode.left != null) {
            postorder(treeNode.left);
        }
        if (treeNode.right != null) {
            postorder(treeNode.right);
        }
        System.out.print(treeNode.val);
        System.out.print(" ");
    }

    public void preorder_xh(TreeNode root) {
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
            System.out.print(res.pop());
            System.out.print(" ");
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        tree.inorder(node);
        System.out.println();
        tree.preorder(node);
        System.out.println();
        tree.postorder(node);
        System.out.println();
        tree.preorder_xh(node);
        System.out.println();
        tree.inorder_xh(node);
        System.out.println();
        tree.postorder_xh(node);
    }

}
