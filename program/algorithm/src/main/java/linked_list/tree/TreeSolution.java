package linked_list.tree;

import linked_list.ListNode;

import java.util.*;

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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judgeNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean judgeNode(TreeNode root, long min, long max) {
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean flag = true;
        if (root.left != null) {
            if (root.left.val < root.val && root.left.val > min) {
                flag = judgeNode(root.left, min, root.val);
            }else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val && root.right.val < max) {
                flag &= judgeNode(root.right, root.val, max);
            }else {
                return false;
            }
        }
        return flag;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = 1;
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        while (res.size() > 0) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : res) {
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            min++;
            res = tmp;
        }
        return min;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        IntegerHolder holder = new IntegerHolder();
        holder.k = 0;
        return getRoot(holder, preorder, 0, inorder.length, map);
    }

    private TreeNode getRoot(IntegerHolder preIndex, int[] preorder, int inHead, int inTail, Map<Integer, Integer> map) {
        if (inHead == inTail) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex.k]);
        int index = map.get(preorder[preIndex.k]);
        preIndex.k++;
        root.left = getRoot(preIndex, preorder, inHead, index, map);
        root.right = getRoot(preIndex, preorder, index + 1, inTail, map);
        return root;
    }

    class IntegerHolder{
        int k;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        IntegerHolder holder = new IntegerHolder();
        holder.k = postorder.length-1;
        return helper(holder, postorder, 0, inorder.length, in);
    }

    private TreeNode helper(IntegerHolder holder, int[] postorder, int inHead, int inTail, Map<Integer,Integer> in) {
        if (inHead == inTail) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[holder.k]);
        int index = in.get(postorder[holder.k]);
        holder.k--;
        root.right = helper(holder, postorder, index + 1, inTail, in);
        root.left = helper(holder, postorder, inHead, index, in);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int head, int tail) {
        if (head == tail) {
            return null;
        }
        int mid = (head + tail) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, head, mid);
        root.right = sortedArrayToBST(nums, mid + 1, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(head.val);
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return sortedArrayToBST(nums, 0, list.size());
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == right && left == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<Integer> resroot = new ArrayList<>();
        resroot.add(root.val);
        res.add(resroot);
        int flag = 1;
        while (!list.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            LinkedList<Integer> partRes = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).left != null) {
                    tmp.add(list.get(i).left);
                    if (flag == -1) {
                        partRes.add(list.get(i).left.val);
                    }else {
                        partRes.addFirst(list.get(i).left.val);
                    }
                }
                if (list.get(i).right != null) {
                    tmp.add(list.get(i).right);
                    if (flag == -1) {
                        partRes.add(list.get(i).right.val);
                    }else {
                        partRes.addFirst(list.get(i).right.val);
                    }
                }
            }
            flag *= -1;
            list = tmp;
            if (partRes.size() > 0) {
                res.add(partRes);
            }
        }
        return res;
    }

    public void recoverTree(TreeNode root) {
        TreeNode firstNode = null;
        TreeNode secondNode = null;

        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val < pre.val) {
                if (firstNode == null) {
                    firstNode = pre;
                    secondNode = root;
                } else {
                    secondNode = root;
                }
            }else {
                pre = root;
            }
            root = root.right;
        }
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root.left != null || root.right != null) {
            if (root.left != null) {
                TreeNode lastRight = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode ri = root.right;
                while (ri.right != null) {
                    ri = ri.right;
                }
                ri.right = lastRight;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();
//        int[] pre = {3,9,20,15,7};
//        int[] in = {9,3,15,20,7};
//        solution.buildTree(pre, in);
//        ListNode head = new ListNode(-10);
//        head.next = new ListNode(-3);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(9);
//        solution.sortedListToBST(head);
//        TreeNode wrong = new TreeNode(1);
//        wrong.right = new TreeNode(3);
//        wrong.right.right = new TreeNode(2);
//        wrong.right.right.right = new TreeNode(4);
//        System.out.println(solution.preDg(wrong));
//        solution.recoverTree(wrong);
//        System.out.println(solution.preDg(wrong));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
        while (root!=null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

}
