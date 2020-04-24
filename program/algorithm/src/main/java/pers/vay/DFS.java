package pers.vay;

import pers.vay.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author VAY
 * 深度优先遍历
 */
public class DFS {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        char[][] flag = new char[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || flag[i][j] == '1') {
                    continue;
                } else {
                    sum++;
                    find(i, j, grid, flag);
                }
            }
        }
        return sum;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        int[][] flag = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && flag[i][j] == 0) {
                    int k = dfs2(grid, flag, i, j);
                    if (max < k) {
                        max = k;
                    }
                }
            }
        }
        return max;
    }

    private int dfs2(int[][] grid, int[][] flag, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return 0;
        }
        if (j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (flag[i][j] == 1) {
            return 0;
        }
        if (grid[i][j] == 1) {
            flag[i][j] = 1;
            return 1 + dfs2(grid, flag, i + 1, j) + dfs2(grid, flag,  i, j + 1) + dfs2(grid, flag, i - 1, j) + dfs2(grid, flag, i, j - 1);
        } else {
            return 0;
        }
    }

    private void find(int i, int j, char[][] grid, char[][] flag) {
        if (grid[i][j] == '1') {
            flag[i][j] = '1';
            if (i >= 1 && flag[i - 1][j] != '1') {
                find(i - 1, j, grid, flag);
            }
            if (i + 1 < grid.length && flag[i + 1][j] != '1') {
                find(i + 1, j, grid, flag);
            }
            if (j >= 1 && flag[i][j - 1] != '1') {
                find(i, j - 1, grid, flag);
            }
            if (j + 1 < grid[0].length && flag[i][j + 1] != '1') {
                find(i, j + 1, grid, flag);
            }
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        } else {
            if (root.left == null) {
                return hasPathSum(root.right, sum - root.val);
            } else if (root.right == null) {
                return hasPathSum(root.left, sum - root.val);
            } else {
                return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> source = new ArrayList<>();
        for (int i : nums) {
            source.add(i);
        }
        back(res, source, 0);
        return res;
    }

    private void back(List<List<Integer>> res, List<Integer> source, int index) {
        if (index == source.size()) {
            res.add(new ArrayList<>(source));
            return;
        }
        for (int i = index; i < source.size(); i++) {
            Collections.swap(source, i, index);
            back(res, source, index + 1);
            Collections.swap(source, i, index);
        }
    }

}
