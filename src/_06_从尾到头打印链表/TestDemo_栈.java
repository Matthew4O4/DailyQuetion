package _06_从尾到头打印链表;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * @Author: matthew
 * @Date: 2023/1/2 18:08
 */
public class TestDemo_栈 {

    /**
     * 栈: 将元素全部放入栈中,利用栈的特性
     */
    static int[] reversePrint(ListNode listNode) {
        if (listNode == null) {
            return new int[0];
        }
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode node = listNode;
        while (node != null) {
            listNodeStack.push(node);
            node = node.next;
        }
        int[] target = new int[listNodeStack.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = listNodeStack.pop().val;
        }
        return target;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(Arrays.toString(reversePrint(listNode1)));
    }

}
