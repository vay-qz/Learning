package pers.vay;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import pers.vay.structure.ListNode;
import pers.vay.structure.StructureUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList linkedList = new MyLinkedList();

    @Test
    void mergeKLists() {
        ListNode[] nodes = new ListNode[3];
        nodes[0] = StructureUtils.getListFromArray(Lists.newArrayList(new Integer[]{1,4,5}));
        nodes[1] = StructureUtils.getListFromArray(Lists.newArrayList(new Integer[]{1,3,4}));
        nodes[2] = StructureUtils.getListFromArray(Lists.newArrayList(new Integer[]{2,6}));
        ListNode res = linkedList.mergeKLists(nodes);
        while (true) {
            System.out.println(res.val);
            res = res.next;
            if (res == null) {
                break;
            }
        }
    }
}