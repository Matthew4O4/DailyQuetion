package _22_链表中倒数第k个节点;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {

    /**
     * 查找倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 当前节点
        //
        ListNode pointA = head;
        ListNode pointB = head;

        for (int i = 0; i < k; i++) {
            pointB = pointB.next;
        }

        while (pointB != null) {
            pointB = pointB.next;
            pointA = pointA.next;
        }
        return pointA;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.getKthFromEnd(new ListNode(1), 1));
    }
}
