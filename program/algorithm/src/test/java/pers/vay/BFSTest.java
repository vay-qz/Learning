package pers.vay;

import org.junit.jupiter.api.Test;
import pers.vay.structure.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    BFS bfs = new BFS();

    @Test
    void rightSideView() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);
        int[] except = {1, 3, 4};
        List<Integer> res = bfs.rightSideView(node);
        int[] pp = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            pp[i] = res.get(i);
        }
        assertArrayEquals(pp, except);
    }
}