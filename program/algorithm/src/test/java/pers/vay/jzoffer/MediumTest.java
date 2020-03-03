package pers.vay.jzoffer;

import org.junit.jupiter.api.Test;
import pers.vay.structure.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class MediumTest {

    Medium medium = new Medium();

    @Test
    void buildTree() {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = medium.buildTree(pre, in);
        System.out.println(node.val);
    }
}