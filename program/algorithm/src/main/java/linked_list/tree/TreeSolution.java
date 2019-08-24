package linked_list.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeSolution {

    public List<Integer> preDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preRes(res, root);
        return res;
    }

    private void preRes(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            preRes(res, root.left);
        }
        if (root.right != null) {
            preRes(res, root.right);
        }
    }

    public List<Integer> inDg(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inRes(res, root);
        return res;
    }

    private void inRes(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if(root.left != null) {
            inRes(res, root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inRes(res, root.right);
        }
    }

    public List<Integer> postDg (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postRes(res, root);
        return res;
    }

    private void postRes(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            postRes(res, root.left);
        }
        if (root.right != null) {
            postRes(res, root.right);
        }
        res.add(root.val);
    }

    public List<Integer> preXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public List<Integer> inXh(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.empty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> postXh(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            //每次找出后序遍历的最后一个
            root = stack.pop();
            res.addFirst(root.val);
            if(root.left != null) {
                stack.push(root.left);
            }
            if(root.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> source = new ArrayList<>();
        source.add(root);
        while (source.size() > 0) {
            res.add(getValues(source));
            List<TreeNode> newSource = new ArrayList<>();
            for (TreeNode node : source) {
                if (node.left != null) {
                    newSource.add(node.left);
                }
                if (node.right != null) {
                    newSource.add(node.right);
                }
            }
            source = newSource;
        }
        return res;
    }

    private List<Integer> getValues(List<TreeNode> source) {
        List<Integer> res = new ArrayList<>();
        for (TreeNode node : source) {
            res.add(node.val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = solution.levelOrder(root);
        System.out.println(res);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==q && q ==null) {
            return true;
        }
        if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }
        List<TreeNode> tmp1 = new ArrayList<>();
        List<TreeNode> tmp2 = new ArrayList<>();
        if (p.val == q.val) {
            tmp1.add(p);
            tmp2.add(q);
        }else {
            return false;
        }
        while (tmp1.size() > 0) {
            List<TreeNode> t1 = new ArrayList<>();
            List<TreeNode> t2 = new ArrayList<>();
            for (int i = 0; i < tmp1.size(); i++) {
                TreeNode node1left = tmp1.get(i).left;
                TreeNode node2left = tmp2.get(i).left;
                TreeNode node1right = tmp1.get(i).right;
                TreeNode node2right = tmp2.get(i).right;
                if (!isSame(node1left, node2left, t1, t2)) {
                    return false;
                }
                if (!isSame(node1right, node2right, t1, t2)) {
                    return false;
                }
            }
            tmp1 = t1;
            tmp2 = t2;
        }
        return true;
    }

    private boolean isSame(TreeNode node1, TreeNode node2, List<TreeNode> res1, List<TreeNode> res2) {
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                res1.add(node1);
                res2.add(node2);
                return true;
            }else {
                return false;
            }
        }else if (node1 == null && node2 == null){
            return true;
        }else {
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxChildDepth(root.left, root.right) + 1;
    }

    private int maxChildDepth(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 0;
        }else {
            int leftMax;
            if (left != null) {
                 leftMax = maxChildDepth(left.left, left.right) + 1;
            } else {
                leftMax = 0;
            }
            int rightMax;
            if (right != null) {
                rightMax = maxChildDepth(right.left, right.right) + 1;
            } else {
                rightMax = 0;
            }
            return leftMax > rightMax ? leftMax : rightMax;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        FlagHolder flagHolder = new FlagHolder();
        sameDepth(root.left, root.right, flagHolder);
        return flagHolder.flag;
    }

    private int sameDepth(TreeNode left, TreeNode right, FlagHolder flag) {
        if (left == null && right == null) {
            return 0;
        }else {
            int leftMax;
            if (left != null) {
                leftMax = sameDepth(left.left, left.right, flag) + 1;
            } else {
                leftMax = 0;
            }
            int rightMax;
            if (right != null) {
                rightMax = sameDepth(right.left, right.right, flag) + 1;
            } else {
                rightMax = 0;
            }
            if (leftMax - rightMax > 1 || leftMax - rightMax < -1) {
                flag.flag = false;
            }
            return leftMax > rightMax ? leftMax : rightMax;
        }
    }

    class FlagHolder {
        boolean flag = true;
    }

}
