package pers.vay;

import pers.vay.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        res.add(root.val);
        while (true) {
            List<TreeNode> temps = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    temps.add(node.left);
                }
                if (node.right != null) {
                    temps.add(node.right);
                }
            }
            if (temps.size() == 0) {
                break;
            }
            res.add(temps.get(temps.size() - 1).val);
            nodes = temps;
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> sums = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
        }
        List<TreeNode> nodes = new ArrayList<>();
        while (!roots.isEmpty()) {
            for (int i = 0; i < roots.size(); i++) {
                if (roots.get(i).left != null) {
                    nodes.add(roots.get(i).left);
                }
                if (roots.get(i).right != null) {
                    nodes.add(roots.get(i).right);
                }
            }
            sums.add(roots);
            roots = nodes;
            nodes = new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        for (List<TreeNode> nodes1 : sums) {
            List<Integer> rr = new ArrayList<>();
            if (flag) {
                for (int i = nodes1.size() - 1; i >= 0; i--) {
                    rr.add(nodes1.get(i).val);
                }
            } else {
                for (int i = 0; i < nodes1.size(); i++) {
                    rr.add(nodes1.get(i).val);
                }
            }
            flag ^= true;
            res.add(rr);
        }
        return res;
    }

    public int orangesRotting(int[][] grid) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Integer> queue = new ArrayDeque<>();
        int L = 10;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * L + j);
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            int x = t / L;
            int y = t % L;
            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                    queue.add(nx * L + ny);
                    grid[nx][ny] = grid[x][y] + 1;
                    res = grid[nx][ny];
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res == 0 ? 0 : res - 2;
    }

    public int maxDistance(int[][] grid) {
        int L = 100;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(i * 100 + j);
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int num = queue.peek();
            int ii = num / L;
            int jj = num % L;
            int time = 1;
            int minx = ii - time;
            int miny = jj - time;
            int maxx = ii + time;
            int maxy = ii + time;
            boolean conti = true;
            for (int i = minx; i < maxx; i++) {
                for (int j = miny; j < maxy; j++) {
                    if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length
                            && grid[i][j] == 1
                            && (Math.abs(i - ii) + Math.abs(j - jj)) == time) {
                        conti = false;
                        break;
                    }
                }
                if (!conti) {
                    queue.remove();
                    break;
                }
            }
            max++;
            time++;
        }
        return max;
    }

}
