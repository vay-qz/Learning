package pers.vay.linked_list;

import org.junit.jupiter.api.Test;
import pers.vay.structure.ListNode;


class ListNodeTest {

    @Test
    void reverse_oneNode() {
        ListNode head = new ListNode(1);
        ListNode res = ListNode.reverse(head);
        printListNode(res);
    }

    @Test
    void reverse_twoNode() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode res = ListNode.reverse(head);
        printListNode(res);
    }

    @Test
    void reverse_more_than_three_node() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        ListNode res = ListNode.reverse(head);
        printListNode(res);
    }

    private void printListNode(ListNode res) {
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}