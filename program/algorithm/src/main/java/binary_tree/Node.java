package binary_tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private Node prev;
    private Node next;
    private int value;
}
