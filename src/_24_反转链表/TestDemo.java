package _24_反转链表;

/**
 * @Description: 输入头结点
 * 反转链表后输出头节点
 * @Author: matthew
 */
public class TestDemo {

    public ListNode reverseList(ListNode head) {
        /**
         * 两两交换
         *  A B C
         *  b -> a
         *  c -> b
         *  d -> c
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;

        ListNode pre = null;
        while (cur != null) {
            // cur B临时节点
            ListNode temp = cur.next;
            cur.next = pre;

            // pre 前一个节点
            pre = cur;
            // curA 当前节点
            cur = temp;
        }

        return pre;
    }
}
