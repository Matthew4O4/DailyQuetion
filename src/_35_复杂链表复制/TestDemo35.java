package _35_复杂链表复制;

import java.util.HashMap;

/**
 * @Description: 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * @Author: matthew
 */
public class TestDemo35 {
    /**
     *
     */
    HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!nodeNodeHashMap.containsKey(head)) {
            Node node = new Node(head.val);
            nodeNodeHashMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        } else {
            return nodeNodeHashMap.get(head);
        }
    }


}
