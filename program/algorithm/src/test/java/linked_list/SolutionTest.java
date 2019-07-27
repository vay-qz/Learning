package linked_list;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode e = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode f = new ListNode(4);
        a.next = b; b.next = e;
        c.next = d; d.next = f;
        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(a, c);
        printListNode(res);
    }

    private void printListNode(ListNode res) {
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    void add() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(0);
        a.next = b;
        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(a, c);
        printListNode(res);
    }

    @Test
    public void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring("1"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring(" "));
        Assert.assertEquals(2, solution.lengthOfLongestSubstring("au"));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("aabaab!bb"));

    }

}