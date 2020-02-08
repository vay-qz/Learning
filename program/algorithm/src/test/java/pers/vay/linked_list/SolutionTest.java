package pers.vay.linked_list;


import org.junit.jupiter.api.Test;
import pers.vay.structure.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, solution.lengthOfLongestSubstring("1"));
        assertEquals(1, solution.lengthOfLongestSubstring(" "));
        assertEquals(2, solution.lengthOfLongestSubstring("au"));
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
        assertEquals(3, solution.lengthOfLongestSubstring("aabaab!bb"));

    }

    @Test
    public void findMedianSortedArrays() {
        Solution solution = new Solution();
        assertEquals(3.5, solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6}), 0.01);
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}), 0.01);
        assertEquals(23.0, solution.findMedianSortedArrays(new int[]{2, 5, 8, 52, 411}, new int[]{5, 9, 23, 73, 654, 3000}), 0.01);
        assertEquals(5.0, solution.findMedianSortedArrays(new int[]{2, 5}, new int[]{5, 9}), 0.01);
        assertEquals(5.0, solution.findMedianSortedArrays(new int[]{2}, new int[]{5, 9}), 0.01);
        assertEquals(7.0, solution.findMedianSortedArrays(new int[]{}, new int[]{5, 9}), 0.01);
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4}), 0.01);
        assertEquals(2, solution.findMedianSortedArrays(new int[]{1,1,3,3}, new int[]{1,1,3,3}), 0.01);
    }

    @Test
    public void convert() {
        Solution solution = new Solution();
        assertEquals(solution.convert("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        assertEquals(solution.convert("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        assertEquals(solution.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        assertEquals(solution.convert("A", 1), "A");
        assertEquals(solution.convert("AB", 1), "AB");
        assertEquals(solution.convert("ABCDE", 2), "ACEBD");
    }

    @Test
    public void convert_official() {
        Solution solution = new Solution();
        assertEquals(solution.convert_official("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        assertEquals(solution.convert_official("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        assertEquals(solution.convert_official("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        assertEquals(solution.convert_official("A", 1), "A");
        assertEquals(solution.convert_official("AB", 1), "AB");
        assertEquals(solution.convert_official("ABCDE", 2), "ACEBD");
    }

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
//        assertEquals(solution.longestPalindrome("babad"), "bab");
//        assertEquals(solution.longestPalindrome("abba"), "abba");
//        assertEquals(solution.longestPalindrome("a"), "a");
//        assertEquals(solution.longestPalindrome("cbbd"), "bb");
//        assertEquals(solution.longestPalindrome("ab"), "a");
//        assertEquals(solution.longestPalindrome("ccc"), "ccc");
        assertEquals(solution.longestPalindrome("abcda"), "a");
    }

    @Test
    public void beveled() {
        Solution solution = new Solution();
        assertEquals(solution.beveled(2, 3, 1, 2), false);
    }



}