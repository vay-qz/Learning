package linked_list;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void findMedianSortedArrays() {
        Solution solution = new Solution();
        Assert.assertEquals(3.5, solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6}), 0.01);
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}), 0.01);
        Assert.assertEquals(23.0, solution.findMedianSortedArrays(new int[]{2, 5, 8, 52, 411}, new int[]{5, 9, 23, 73, 654, 3000}), 0.01);
        Assert.assertEquals(5.0, solution.findMedianSortedArrays(new int[]{2, 5}, new int[]{5, 9}), 0.01);
        Assert.assertEquals(5.0, solution.findMedianSortedArrays(new int[]{2}, new int[]{5, 9}), 0.01);
        Assert.assertEquals(7.0, solution.findMedianSortedArrays(new int[]{}, new int[]{5, 9}), 0.01);
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4}), 0.01);
        Assert.assertEquals(2, solution.findMedianSortedArrays(new int[]{1,1,3,3}, new int[]{1,1,3,3}), 0.01);
    }

    @Test
    public void convert() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.convert("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        Assert.assertEquals(solution.convert("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        Assert.assertEquals(solution.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        Assert.assertEquals(solution.convert("A", 1), "A");
        Assert.assertEquals(solution.convert("AB", 1), "AB");
        Assert.assertEquals(solution.convert("ABCDE", 2), "ACEBD");
    }

    @Test
    public void convert_official() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.convert_official("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        Assert.assertEquals(solution.convert_official("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        Assert.assertEquals(solution.convert_official("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        Assert.assertEquals(solution.convert_official("A", 1), "A");
        Assert.assertEquals(solution.convert_official("AB", 1), "AB");
        Assert.assertEquals(solution.convert_official("ABCDE", 2), "ACEBD");
    }

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
//        Assert.assertEquals(solution.longestPalindrome("babad"), "bab");
//        Assert.assertEquals(solution.longestPalindrome("abba"), "abba");
//        Assert.assertEquals(solution.longestPalindrome("a"), "a");
//        Assert.assertEquals(solution.longestPalindrome("cbbd"), "bb");
//        Assert.assertEquals(solution.longestPalindrome("ab"), "a");
//        Assert.assertEquals(solution.longestPalindrome("ccc"), "ccc");
        Assert.assertEquals(solution.longestPalindrome("abcda"), "a");
    }

    @Test
    public void beveled() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.beveled(2, 3, 1, 2), false);
    }

    @Test
    public void inorderTraversal() {
        Solution solution = new Solution();
        TreeNode root = getRoot();
        List<Integer> res = getRes();
        Assert.assertEquals(res, solution.inorderTraversalRecursive(root));
    }

    @Test
    public void inorderTraversalNonRecursive() {
        Solution solution = new Solution();
        TreeNode root = getRoot();
        List<Integer> res = getRes();
        Assert.assertEquals(res, solution.inorderTraversalNonRecursive(root));
    }

    private List<Integer> getRes() {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(3);
        res.add(2);
        return res;
    }

    TreeNode getRoot() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    @Test
    public void isSameTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);


        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(1);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);

        Solution solution = new Solution();
        Assert.assertEquals(solution.isSameTree(root, root2), true);
        Assert.assertEquals(solution.isSameTree(root, root3), false);
    }

}