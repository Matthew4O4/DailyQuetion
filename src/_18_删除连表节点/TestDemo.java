package _18_删除连表节点;

/**
 * @Description: 删除连表中的节点.需要两个指针, 一前一后,
 * @Author: matthew
 */
public class TestDemo {

    ListNode deleteNode(ListNode root, int target) {


        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root.next;
        }

        ListNode pre = root;
        ListNode cur = root.next;

        while (cur != null) {
            if (cur.val == target) {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return root;
    }


}
