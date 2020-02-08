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
}
