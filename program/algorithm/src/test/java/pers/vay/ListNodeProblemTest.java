package pers.vay;

import org.junit.jupiter.api.Test;
import pers.vay.structure.ListNode;
import pers.vay.structure.StructureUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeProblemTest {

    ListNodeProblem problem = new ListNodeProblem();

    @Test
    void swapPairs() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        ListNode node = problem.swapPairs(StructureUtils.getListFromArray(integers));
        while (node != null) {
            System.out.print(node.val);
            System.out.println(" ");
            node = node.next;
        }
    }
}