package pers.vay.structure;

import java.util.ArrayList;
import java.util.List;

public class StructureUtils {

    public static ListNode getListFromArray(List<Integer> array) {
        ListNode root = new ListNode(array.get(0));
        ListNode node = root;
        for (int i = 1; i < array.size(); i++) {
            ListNode node1 = new ListNode(array.get(i));
            node.next = node1;
            node = node1;
        }
        return root;
    }

    public static TreeNode getBinaryTreeFromArray(List<String> array) {
        TreeNode root = new TreeNode(Integer.parseInt(array.get(0)));
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < array.size(); i++) {
            List<TreeNode> temps = new ArrayList<>();
            for (TreeNode node : list) {
                if (i < array.size()) {
                    if (!array.get(i).equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(array.get(i)));
                        temps.add(node.left);
                    }
                } else {
                    break;
                }
                i++;
                if (i + 1 < array.size()) {
                    if (!array.get(i).equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(array.get(i)));
                        temps.add(node.right);
                    }
                } else {
                    break;
                }
                i++;
            }
            list = temps;
        }
        return root;
    }

}
