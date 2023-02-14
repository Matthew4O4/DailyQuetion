package _36_二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: -
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * -      4
 * -    2   5
 * -  1  3
 * <p>
 * 1 2 3 4 5
 * <p>
 * 先指到左艮
 * <p>
 * 每个节点指向 右节点, 若没有右节点 指向父节点
 * @Author: matthew
 */
public class TestDemo36 {

    public Node treeToDoublyList(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        ArrayList<Node> nodes = new ArrayList<>();

        myTreeToDoublyList(root, nodes);
        Node head = nodes.get(0);
        Node end = nodes.get(nodes.size() - 1);
        head.left = end;
        head.right = nodes.get(1);
        end.right = head;
        end.left=nodes.get(nodes.size()-2);
        if (nodes.size()==2){
            return head;
        }
        for (int i = 1; i < nodes.size() - 1; i++) {
            Node temp = nodes.get(i);
            temp.left = nodes.get(i - 1);
            temp.right = nodes.get(i + 1);
        }
        return head;
    }

    public Node myTreeToDoublyList(Node root, List<Node> list) {
        if (root == null) {
            return null;
        }
        // 前制节点
        root.left = myTreeToDoublyList(root.left, list);
        list.add(root);
        // 后面的节点
        root.right = myTreeToDoublyList(root.right, list);
        return root;
    }

    public static void main(String[] args) {
        TestDemo36 testDemo36 = new TestDemo36();
        Node nod2 = new Node(2);
        Node nod4 = new Node(4,nod2,null);
//        Node nod5 = new Node(5);
//        Node nod1 = new Node(1);
//        Node nod3 = new Node(3);
//        nod4.left = nod2;
//        nod4.right = nod5;
//
//        nod2.left = nod1;
//        nod2.right = nod3;

        System.out.println(testDemo36.treeToDoublyList(nod4));
    }


}
