package linked_list;

import java.util.*;

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
        int prefix1 = 0;
        int prefix2 = 0;
        int sum = nums1.length + nums2.length;
        List<Integer> res = new ArrayList<>();
        getRes(prefix1, prefix2, res, nums1, nums2);
        res.sort(Comparator.comparingInt(a -> a));
        if(sum % 2 == 1) {
            return res.get(sum/2-prefix1-prefix2);
        }else {
            return ((double)res.get(sum/2-prefix1-prefix2) + res.get(sum/2-prefix1-prefix2-1)) / 2.0;
        }
    }

    private void getRes(int prefix1, int prefix2, List<Integer> res, int[] nums1, int[] nums2) {
        if(nums1.length <= 2 && nums2.length <= 2) {
            addArray2List(res, nums1);
            addArray2List(res, nums2);
            return;
        }
        double mid1 = getMidian(nums1);
        double mid2 = getMidian(nums2);
        int[] nums1After;
        int[] nums2After;
        if(mid1 < mid2) {
            if(nums1.length <= 2) {
                nums1After = nums1;
            }else {
                int nums1Mid;
                if(nums1.length % 2 == 0) {
                    nums1Mid = nums1.length/2 - 1;
                }else {
                    nums1Mid = nums1.length/2;
                }
                nums1After = Arrays.copyOfRange(nums1, nums1Mid, nums1.length);
                prefix1 += nums1Mid;
            }
            if(nums2.length <= 2) {
                nums2After = nums2;
            }else {
                nums2After = Arrays.copyOfRange(nums2, 0, nums2.length/2);
            }
        }else {
            if(nums1.length <= 2) {
                nums1After = nums1;
            }else {
                nums1After = Arrays.copyOfRange(nums1, 0, nums1.length/2);
            }
            if(nums2.length <= 2) {
                nums2After = nums2;
            }else {
                int nums2Mid;
                if(nums2.length % 2 == 0) {
                    nums2Mid = nums2.length/2 - 1;
                }else {
                    nums2Mid = nums2.length/2;
                }
                prefix2 += nums2Mid;
                nums2After = Arrays.copyOfRange(nums2, nums2Mid, nums2.length);
            }
        }
        getRes(prefix1, prefix2, res, nums1After, nums2After);

    }

    private double getMidian(int[] nums) {
        if(nums.length%2==0) {
            return ((double)nums[nums.length/2] + (double)nums[nums.length/2 - 1])/(double)2;
        }else {
            return nums[nums.length/2];
        }
    }

    private void addArray2List(List res, int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 8, 52, 411};
        int[] b = {5, 9, 23, 73, 654, 3000};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(a, b));
    }

}
