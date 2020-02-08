package pers.vay;

import pers.vay.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> res = new ArrayList<>();
        for (ListNode node : lists) {
            if (node != null) {
                res.add(node);
            }
        }
        if (res.size() == 0) {
            return null;
        }
        while (true) {
            if (res.size() == 1) {
                return res.get(0);
            }
            List<ListNode> listNodes = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                if (i + 1 < res.size()) {
                    listNodes.add(merge2Lists(res.get(i), res.get(i + 1)));
                    i++;
                } else {
                    listNodes.add(res.get(i));
                }
            }
            res = listNodes;
        }
    }

    private ListNode merge2Lists(ListNode listNode, ListNode listNode1) {
        ListNode root = new ListNode(listNode.val);
        ListNode node = root;
        while (true) {
            if (listNode == null) {
                node.next = listNode1;
                return root.next;
            }
            if (listNode1 == null) {
                node.next = listNode;
                return root.next;
            }
            if (listNode.val < listNode1.val) {
                node.next = new ListNode(listNode.val);
                listNode = listNode.next;
            } else {
                node.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            }
            node = node.next;
        }
    }
}
