package linked_list;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        reverse(l1);
        return null;
    }

    private ListNode reverse(ListNode l1) {
        if(l1.next == null) {
            return l1;
        }
        ListNode head = l1;
        ListNode target = l1.next;
        while(target != null){
            ListNode temp = target;
            target = target.next;

            head.next = temp;
            temp.next = temp;

        }
    }

}