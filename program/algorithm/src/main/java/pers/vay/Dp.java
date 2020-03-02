package pers.vay;


import pers.vay.structure.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 动态规划算法
 */
public class Dp {
    /**
     * 最大子序列
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 不同路径和
     * https://leetcode-cn.com/problems/unique-paths
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    /**
     * 有障碍的不同路径和
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int high = obstacleGrid.length;
        if (width == 1) {
            for (int i = 0; i < high; i++) {
                if (obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (high == 1) {
            for (int i = 0; i < width; i++) {
                if (obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        int dp[][] = new int[high][width];
        boolean flag = false;
        for (int i = 0; i < high; i++) {
            if (flag) {
                dp[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1) {
                    flag = true;
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            }
        }
        flag = false;
        for (int i = 0; i < width; i++) {
            if (flag) {
                dp[0][i] = 0;
            } else {
                if (obstacleGrid[0][i] == 1) {
                    flag = true;
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
        }
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[high - 1][width - 1];
    }
    /**
     * 最小路径和
     *
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int high = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[high][width];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    int temp = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                    dp[i][j] = temp + grid[i][j];
                }
            }
        }
        return dp[high - 1][width - 1];
    }

    /**
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 链接：https://leetcode-cn.com/problems/house-robber
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < len; i++) {
            int t = dp[i - 2] + nums[i];
            if (t > dp[i - 1]) {
                dp[i] = t;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int mmax = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int max = dp[j - 1] > prices[j] ? dp[j - 1] : prices[j];
                dp[j] = max;
            }
            if (dp[len - 1] - prices[i] > mmax) {
                mmax = dp[len - 1] - prices[i];
            }
            for (int j = 0; j < len; j++) {
                dp[j] = 0;
            }
        }
        return mmax;
    }

    /**
     * 区间和都可以转化为求差值的问题，求差值的问题都可以转化为区间和的问题
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] diff = new int[len];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int sum = diff[0] > 0 ? diff[0] : 0;
        for (int i = 1; i < len; i++) {
            if (diff[i] + sum > 0) {
                sum = diff[i] + sum;
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     *
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     *
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     *
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        if (N % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     *
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     *
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 1) {
            return cost[0];
        }
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = (dp[i - 1] < dp[i - 2] ? dp[i - 1] : dp[i - 2]) + cost[i];
        }
        return dp[len - 1] < dp[len - 2] ? dp[len - 1] : dp[len - 2];
    }

    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     */
    public static class NumArray {

        int[] dp;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                dp = new int[0];
                return;
            }
            int len = nums.length;
            dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return dp[j];
            } else {
                return dp[j] - dp[i - 1];
            }
        }
    }

    public int[] countBits_1(int num) {
        int[] dp = new int[num + 1];
        //乘数
        int cs = 1;
        for (int i = 1; i <= num;) {
            for (int j = 0; j < cs && i <= num; j++, i++) {
                dp[i] = dp[j] + 1;
            }
            cs = cs << 1;
        }
        return dp;
    }

    public int[] countBits_2(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public int[] countBits_3(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * @param triangle 三角形
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        int[] dp2 = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> tri = triangle.get(i);
            for (int j = 0; j < tri.size(); j++) {
                if (j == 0) {
                    dp2[j] = dp[j] + tri.get(j);
                } else if (j == tri.size() - 1) {
                    dp2[j] = dp[j - 1] + tri.get(j);
                } else {
                    dp2[j] = tri.get(j) + (dp[j - 1] < dp[j] ? dp[j - 1] : dp[j]);
                }
            }
            for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
                dp[j] = dp2[j];
            }
        }
        int lj = Integer.MAX_VALUE;
        for (Integer i : dp) {
            if (i < lj) {
                lj = i;
            }
        }
        return lj;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.length() == 1) {
            return dp[s.length() - 1];
        }

        if (s.charAt(1) == '0') {
            if (s.charAt(0) > '2') {
                return 0;
            }
            dp[1] = 1;
        } else if (s.charAt(0) > '2' || (s.charAt(0) == '2' && s.charAt(1) > '6')) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if (s.charAt(i - 1) > '2' || (s.charAt(i - 1) == '2' && s.charAt(i) > '6') || s.charAt(i - 1) == '0') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dpWithoutFirst = new int[nums.length];
        dpWithoutFirst[0] = 0;
        dpWithoutFirst[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = dpWithoutFirst[i - 2] + nums[i];
            dpWithoutFirst[i] = dpWithoutFirst[i - 1] > temp ? dpWithoutFirst[i - 1] : temp;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = dp[i - 2] + nums[i];
            dp[i] = dp[i - 1] > temp ? dp[i - 1] : temp;
        }
        return dp[nums.length - 2] > dpWithoutFirst[nums.length - 1] ? dp[nums.length - 2] : dpWithoutFirst[nums.length - 1];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int t = n;
            for (int j = 1; j*j <= i; j++ ) {
                if (dp[i - j*j] < t) {
                    t = dp[i - j*j];
                }
            }
            dp[i] = t + 1;
        }
        return dp[n];
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return true;
    }

    public String replaceSpace(String s) {
        char[] t = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char tt : t) {
            if (tt == ' ') {
                builder.append("%20");
            } else {
                builder.append(tt);
            }
        }
        return builder.toString();
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> list = new Stack<>();
        while (head != null) {
            list.push(head.val);
            head = head.next;
        }
        int[] t = new int[list.size()];
        for (int i = 0; i < t.length; i++) {
            t[i] = list.pop();
        }
        return t;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            res = res.next;
        }
        return res;
    }

    public int fib(int n) {
        long[] dp = new long[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] > 1000000007) {
                dp[i] %= 1000000007;
            }
        }
        return (int)(dp[n] % 1000000007);
    }

    public String reverseLeftWords(String s, int n) {
        char[] tt = s.toCharArray();
        char[] t1 = Arrays.copyOfRange(tt, 0, n);
        char[] t2 = Arrays.copyOfRange(tt, n, tt.length);
        return new String(t2) + new String(t1);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode t1 = head;
        ListNode t2 = head.next;
        while (t2 != null) {
            if (t2.val == val) {
                t1.next = t2.next;
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();
        while (head!=null) {
            listNodes.push(head);
            head = head.next;
        }
        if (listNodes.isEmpty()) {
            return null;
        }
        ListNode newHead = listNodes.pop();
        ListNode node = newHead;
        while (!listNodes.isEmpty()) {
            node.next = listNodes.pop();
            node = node.next;
        }
        node.next = null;
        return newHead;
    }

    public int[] printNumbers(int n) {
        int t = 1;
        for (int i = 0; i < n; i++) {
            t *= 10;
        }
        int[] res = new int[t - 1];
        for (int i = 0, j = 1; i < t - 1; i++, j++) {
            res[i] = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Dp dp = new Dp();
        dp.printNumbers(1);
    }

}
