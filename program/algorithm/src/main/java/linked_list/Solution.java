package linked_list;

import linked_list.tree.TreeNode;

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
        int sumNum = nums1.length + nums2.length;
        int first = (sumNum + 1) / 2;
        int second = (sumNum + 2) /2;
        if(first == second) {
            return getKth(nums1, 0, nums1.length, nums2, 0, nums2.length, first);
        }else {
            return (getKth(nums1, 0, nums1.length, nums2, 0, nums2.length, first) +
                    getKth(nums1, 0, nums1.length, nums2, 0, nums2.length, second)) * 0.5;
        }
    }

    /**
     * 获取两个有序数组中第k小的数
     * @param nums1 第一个数组
     * @param head1 有效头位置
     * @param length1 第一个数组的长度
     * @param nums2 第二个数组
     * @param head2 有效头位置
     * @param length2 第二个数组的长度
     * @param k k
     * @return 第k小的数
     */
    private int getKth(int[] nums1, int head1, int length1, int[] nums2, int head2, int length2, int k) {
        int remainLen1 = length1 - head1;
        int remainLen2 = length2 - head2;
        //保证nums1是长度较短的数组
        if(remainLen1 > remainLen2) {
            return getKth(nums2, head2, length2, nums1, head1, length1, k);
        }
        //情况1，某一数组中的所有数都小于中位数
        if(remainLen1 == 0) {
            //k=1表示寻找数组中的第一最小值，即nums[0] = nums2[k-1]
            return nums2[head2 + k - 1];
        }
        //情况2，每个数组中都有小于或大于中位数的数
        if(k == 1) {
            return nums1[head1] < nums2[head2] ? nums1[head1] : nums2[head2];
        }
        int removeNum = k/2;
        int remove1 = (remainLen1 < removeNum ? remainLen1 : removeNum);
        int remove2 = (remainLen2 < removeNum ? remainLen2 : removeNum);
        int newHead1 = head1 + remove1;
        int newHead2 = head2 + remove2;
        //比较的是两个数组中newHead之前的那个数的大小
        if(nums1[newHead1 - 1] < nums2[newHead2 - 1]) {
            return getKth(nums1, newHead1, length1, nums2, head2, length2, k - remove1);
        }else {
            return getKth(nums1, head1, length1, nums2, newHead2, length2, k - remove2);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            l.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, l, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> nums, int index) {
        if(index == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for(int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            backtrack(res, nums, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1) {
            return s;
        }
        List<String> strs = new ArrayList<>();
        List<String> strs2 = new ArrayList<>();
        if(numRows == 2) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i < s.length(); i+=2) {
                builder.append(s.charAt(i));
            }
            for(int i = 1;i < s.length(); i+=2) {
                builder.append(s.charAt(i));
            }
            return builder.toString();
        }
        int begin = 0;
        while(true) {
            int end = s.length() < (2 * numRows + begin - 2) ? s.length() : (2 * numRows + begin - 2);
            String a = s.substring(begin, end);
            strs.add(a);
            begin = end;
            if(end == s.length()) {
                break;
            }
        }
        String fullEmpty = new String();
        for(int i = 0; i < numRows; i++) {
            fullEmpty += " ";
        }
        for(int i = 0; i < strs.size(); i++) {
            String tmp = strs.get(i);
            if(tmp.length() < numRows) {
                String empty = new String();
                for(int j = 0; j < numRows - tmp.length(); j++) {
                    empty += " ";
                }
                strs2.add(empty + new StringBuilder(tmp).reverse().toString());
                break;
            }
            strs2.add(new StringBuilder(tmp.substring(0, numRows)).reverse().toString());
            strs2.add(" " + tmp.substring(numRows) + fullEmpty);
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < strs2.size(); j++) {
                char t = strs2.get(j).charAt(numRows - i - 1);
                if(t != ' ') {
                    builder.append(t);
                }
            }
        }

        return builder.toString();

    }

    public String convert_official(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> strs = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            strs.add(new StringBuilder());
        }

        int row = 0;
        int dir = -1;
        for(char c : s.toCharArray()) {
            strs.get(row).append(c);
            if(row == numRows - 1 || row == 0) {
                dir *= -1;
            }
            row += dir;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder stringBuilder : strs) {
            res.append(stringBuilder);
        }
        return res.toString();

    }

    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s;
        }
        String res = null;
        int max = -1;

        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            int more = 0;
            int repeat = 0;
            for(int t = 1; i + t < str.length && str[i] == str[i + t]; t++) {
                repeat++;
            }
            int j = 1;
            for(; i - j >= 0 && (i + j + repeat) < str.length; j++) {
                if(str[i + j + repeat] == str[i -j]) {
                    more += 1;
                }else {
                    break;
                }
            }
            if((more * 2 + repeat) > max) {
                max = more * 2 + repeat;
                res = s.substring(i - more, i + more + repeat + 1);
            }
        }

        return res;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        gasdfa(res, 0, nums, stack, used);
        return res;
    }

    private void gasdfa(List<List<Integer>> res, int index, int[] nums, Stack<Integer> stack, boolean[] used) {
        if(index == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                //与前数相同切前数还没有使用过，表示与前数在同一层，会产生一个相同的分支
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                stack.push(nums[i]);
                used[i] = true;
                gasdfa(res, index + 1, nums, stack, used);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void test() {
        Solution solution = new Solution();
        int[] a= {1, 1,2,3};
        List<List<Integer>> b = solution.permuteUnique(a);
        System.out.println(b);

    }

    public void rotate(int[][] matrix) {
        int copy[][] = new int[matrix.length][];
        for(int i = 0;i < matrix.length; i++) {
            int[] tmp = new int[matrix.length];
            for(int j = 0;j < matrix.length; j++) {
                tmp[j] = matrix[i][j];
            }
            copy[i] = tmp;
        }
//        print2wsz(copy);
        for(int i = 0; i < matrix.length; i++) {
            int[] row = copy[i];
            for(int j = 0; j < row.length; j++) {
                matrix[j][matrix.length - i - 1] = row[j];
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        test();

//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
//        solution.rotate(matrix);
//        print2wsz(matrix);

        List<List<String>> res = solution.solveNQueens(4);
        for(int i = 0; i < res.size(); i++) {
            List<String> t = res.get(i);
            for(String p : t) {
                System.out.println(p);
            }
            System.out.println();
        }
//        System.out.println(solution.solveNQueens(8));
    }

    private static void print2wsz(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0;j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ress = new ArrayList<>();
        Stack<Integer> tmp = new Stack<>();
        solve(ress, tmp, n, 0);
//        System.out.println(ress.size());
        List<List<String>> res = format(ress, n);
        return res;
    }

    private List<List<String>> format(List<List<Integer>> ress, int n) {
        List<List<String>> res = new ArrayList<>();
        for(List<Integer> tmp : ress){
            List<String> p = new ArrayList<>();
            for(Integer i : tmp) {
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0;j < n;j++) {
                    if(j == i) {
                        stringBuilder.append("Q");
                    }else {
                        stringBuilder.append(".");
                    }
                }
                p.add(stringBuilder.toString());
            }
            res.add(p);
        }
        return res;
    }


    private void solve(List<List<Integer>> ress, Stack<Integer> tmp, int n, int row) {
        if(row == n) {
            ress.add(new ArrayList<>(tmp));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isOk(row, col, tmp)) {
                tmp.push(col);
                solve(ress, tmp, n, row + 1);
                tmp.pop();
            }
        }
        return;
    }

    private boolean isOk(int row, int col, List<Integer> tmp) {
        for(int i = 0; i < tmp.size(); i++) {
            if(sameRow(row, i) || sameCol(col, tmp.get(i)) || beveled(row, col, i, tmp.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean beveled(int row, int col, int i, Integer integer) {
        return same(row + col - i - integer, 0) || same(row - i, col - integer);
    }

    private boolean sameCol(int col, Integer integer) {
        return same(col, integer);
    }

    private boolean same(int col, Integer integer) {
        return col == integer;
    }

    private boolean sameRow(int row, int i) {
        return same(row, i);
    }

}
