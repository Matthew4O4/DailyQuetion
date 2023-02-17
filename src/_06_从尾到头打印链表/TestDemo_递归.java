package _06_从尾到头打印链表;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/9 09:41
 */
public class TestDemo_递归 {
    /**
     * 递归
     */
    static int[] reversePrint2(ListNode listNode) {
        if (listNode == null) {
            return new int[0];
        }
        ListNode header = listNode;
        ArrayList<Integer> objects = new ArrayList<>();
        reversePrint2(header, objects);
        int[] ints = new int[objects.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = objects.get(i);
        }
        return ints;
    }

    private static void reversePrint2(ListNode header, ArrayList<Integer> objects) {
        if (header == null) {
            return;
        }
        reversePrint2(header.next, objects);
        objects.add(header.val);
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
        System.out.println(Arrays.toString(reversePrint2(listNode1)));
    }
}
