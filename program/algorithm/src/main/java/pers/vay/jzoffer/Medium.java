package pers.vay.jzoffer;

import pers.vay.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer，中等难度
 */
public class Medium {

    Map<Integer, Integer> inorderMap = new HashMap<>();
    Map<Integer, Integer> preorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        root.left = buildNode(0, inorderMap.get(preorder[0]), inorder);
        root.right = buildNode(inorderMap.get(preorder[0]) + 1, inorder.length, inorder);
        return root;
    }

    private TreeNode buildNode(int leftHead, Integer leftTail, int[] inorder) {
        if (leftHead == leftTail) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        int inorderIndex = -1;
        for (int i = leftHead; i < leftTail; i++) {
            if (preorderMap.get(inorder[i]) < min) {
                min = preorderMap.get(inorder[i]);
                inorderIndex = i;
            }
        }
        TreeNode node = new TreeNode(inorder[inorderIndex]);
        node.left = buildNode(leftHead, inorderMap.get(inorder[inorderIndex]), inorder);
        node.right = buildNode(inorderMap.get(inorder[inorderIndex]) + 1, leftTail, inorder);
        return node;
    }

}
