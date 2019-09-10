package pers.vay;

/**
 * 测试getstatic
 * getstatic -x
 * @author qiaozhe
 */
public class ArthasStatic {

    private static LinkedNode linkedNode;

    static {
        linkedNode = new LinkedNode(1);
        linkedNode.next = new LinkedNode(2);
        linkedNode.next.next = new LinkedNode(3);
        linkedNode.next.next.next = new LinkedNode(4);
    }

}
