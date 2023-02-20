package _52_两个链表的第一个公共节点;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 输入两个链表，找出它们的第一个公共节点。
 * @Author: matthew
 */
public class Test53 {


    /**
     * 思路就是, 将 A 放到 Set中
     * 然后遍历 B ,如果 A 包含他就说明是这个节点开始相同的.   but....除非每个节点都不是相同的
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        // 将A链表加入Set
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            // 循环B链表,只要Set有这个元素,就说明从这里相遇
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
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

        Test53 t53 = new Test53();
        System.out.println(t53.getIntersectionNode(listNode1, listNode3).val);

    }


}
