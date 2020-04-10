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

    /**给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode tail = head;
        ListNode remove = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        if (tail == null) {
            return res.next;
        }
        tail = tail.next;
        while (tail != null) {
            tail = tail.next;
            remove = remove.next;
        }
        remove.next = remove.next.next;
        return res;
    }

    /**将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 :l1;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 !=null) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }
        head.next = l1 == null ? l2 : l1;
        return res.next;
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        //node length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        //k /= length
        k %= length;
        if (k == 0) {
            return head;
        }
        //find newHead index
        int index = length - k;
        temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);


        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNodeProblem problem = new ListNodeProblem();
//        problem.mergeTwoLists(a, b);

        problem.rotateRight(a, 3);
    }

}
