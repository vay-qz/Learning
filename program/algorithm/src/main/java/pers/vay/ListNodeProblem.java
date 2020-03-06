package pers.vay;

import pers.vay.structure.ListNode;

public class ListNodeProblem {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        swap(newHead.next, newHead.next.next);
        return newHead;
    }

    private void swap(ListNode next, ListNode next1) {
        if (next1 == null || next1.next == null) {
            return;
        }
        ListNode node = next1.next;
        next.next = node;
        next1.next = node.next;
        node.next = next1;
        swap(next1, next1.next);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head ;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null || l2 == null) {
            head.next = l1 == null ? l2 : l1;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);


        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNodeProblem problem = new ListNodeProblem();
        problem.mergeTwoLists(a, b);
    }

}
