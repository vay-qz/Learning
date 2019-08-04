package linked_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int prefix1 = -1;
        int prefix2 = -1;
        int sum = nums1.length + nums2.length;
        List<Integer> res = new ArrayList<>();
        getRes(prefix1, prefix2, res, nums1, nums2);
        res.sort(Comparator.comparingInt(a -> a));
        if(sum % 2 == 1) {
            return res.get(sum/2-prefix1-prefix2);
        }else {
            return res.get(sum/2-prefix1-prefix2) + res.get(sum/2-prefix1-prefix2-1);
        }
    }

    private void getRes(int prefix1, int prefix2, List<Integer> res, int[] nums1, int[] nums2) {
        if(nums1.length <= 2 && nums2.length <= 2) {
            res.add(nums1);
            res.add(nums2);
            return;
        }
        int mid1 = nums1[nums1.length/2];
        int mid2 = nums2[nums2.length/2];
        if(mid1 < mid2) {
            getRes(prefix1, prefix2, res, nums1[nums1.length/2~nums1.length], nums2[0~nums1.length/2]);
        }else {
            getRes(prefix1, prefix2, res, nums1[0~nums1.length/2], nums2[nums2.length/2~nums2.length]);
        }

    }

}
