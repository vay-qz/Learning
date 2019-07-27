package linked_list;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = ListNode.reverse(l1);
        ListNode b = ListNode.reverse(l2);
        ListNode c = add(a, b);
        return ListNode.reverse(c);
    }

    public ListNode add(ListNode l1, ListNode l2) {
        int i = l1.val;
        int j = l2.val;
        int sum = i + j;
        int carry = sum / 10;
        if(carry != 0) {
            sum = sum % 10;
        }
        ListNode res = new ListNode(sum);
        ListNode node = res;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null) {
            if(l1==null) {
                i = 0;
            }else {
                i = l1.val;
                l1 = l1.next;
            }
            if(l2==null) {
                j = 0;
            }else {
                j = l2.val;
                l2 = l2.next;
            }
            sum = i + j + carry;
            carry = sum / 10;
            if(carry != 0) {
                sum = sum % 10;
            }
            ListNode next = new ListNode(sum);
            res.next = next;
            res = res.next;
        }
        if(carry != 0) {
            ListNode head = new ListNode(carry);
            res.next = head;
        }
        return node;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int max = 0;
        String tmp = new String();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(tmp.length() == 0) {
                tmp += s.charAt(i);
                num++;
                max = 1;
            }else {
                char b = s.charAt(i);
                int space = tmp.indexOf(b);
                if(space > -1) {
                    if(max < num) {
                        max = num;
                    }
                    tmp = tmp.substring(space + 1, tmp.length()) + b;
                    num = tmp.length();
                }else {
                    tmp += b;
                    num++;
                }
            }
        }
        if(max < num) {
            max = num;
        }
        return max;
    }

}
