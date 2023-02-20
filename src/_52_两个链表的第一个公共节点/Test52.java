package _52_两个链表的第一个公共节点;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 输入两个链表，找出它们的第一个公共节点。
 * @Author: matthew
 */
public class Test52 {
    /**
     * @param headA
     * @param headB
     * @return
     */

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode res = null;
        ListNode curA = headA;
        ListNode curB = headB;
        Stack<ListNode> queueA = new Stack<>();
        Stack<ListNode> queueB = new Stack<>();
        while (curA != null || curB != null) {
            if (curA != null) {
                queueA.add(curA);
                curA = curA.next;
            }
            if (curB != null) {
                queueB.add(curB);
                curB = curB.next;
            }
        }

        while (!queueB.isEmpty() && !queueA.isEmpty()) {
            if (queueA.peek() == queueB.peek()) {
                res = queueB.peek();
                queueA.pop();
                queueB.pop();
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode5;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode5.next = listNode6;

        Test52 test52 = new Test52();
        System.out.println(test52.getIntersectionNode(listNode1, listNode3));


    }


}
