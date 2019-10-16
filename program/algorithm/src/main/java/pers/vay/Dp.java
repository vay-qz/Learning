package pers.vay;

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
}
