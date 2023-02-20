package _54_二叉搜索树的第k大节点;

/**
 * @Description: - 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * -
 * - 示例 1:
 * -
 * - 输入: root = [3,1,4,null,2], k = 1
 * -    3
 * -   / \
 * -  1   4
 * -   \
 * -    2
 * - 输出: 4
 * - 示例 2:
 * -
 * - 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * -        5
 * -       / \
 * -      3   6
 * -     / \
 * -    2   4
 * -   /
 * -  1
 * - 输出: 4
 * - 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * @Author: matthew
 */
public class Test54 {
    int i;
    int r;

    public int kthLargest(TreeNode root, int k) {
        i = k;
        r = 0;
        myKthLargest(root, k);
        return r;
    }

    /**
     * 右树起深度遍历,出栈即可
     * 如果右边有则记录右边
     * 如果右边没有则记录自己
     *
     * @param root
     * @param k
     * @return
     */
    public void myKthLargest(TreeNode root, int k) {
        // 减完则停
        if (root == null || i == 0) {
            return;
        }
        myKthLargest(root.right, k);
        i--;
        if (i == 0) {
            r = root.val;
        }
        // 右中左
        myKthLargest(root.left, k);
    }


}
