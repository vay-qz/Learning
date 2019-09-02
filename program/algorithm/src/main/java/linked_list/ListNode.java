package linked_list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int i) {
        this.val = i;
    }

    public static ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }

        if(head.next.next == null) {
            ListNode tmp = head.next;
            head.next.next = head;
            head.next = null;
            return tmp;
        }

        ListNode first = head;
        ListNode targetPre = first.next;
        ListNode target = first.next.next;
        while(target != null) {
            ListNode toMove = target;
            target = target.next;

            toMove.next = first.next;
            targetPre.next = target;
            first.next = toMove;
        }
        ListNode last = first.next;
        while(last.next != null) {
            last = last.next;
        }
        last.next = first;
        ListNode result = first.next;
        first.next = null;
        return result;
    }

}
