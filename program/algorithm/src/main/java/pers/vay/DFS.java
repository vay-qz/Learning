package pers.vay;

import pers.vay.structure.TreeNode;

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




}
