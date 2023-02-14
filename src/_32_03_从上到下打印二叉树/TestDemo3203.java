package _32_03_从上到下打印二叉树;

import java.util.*;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo3203 {

    /**
     * 从上到下打印二叉树
     * 考查的是二叉树的层级遍历
     * 此版本要求,奇数正序,偶数层倒叙.
     * 我们从root节点开始循环,先将 root节点放入辅助队列A
     *
     * 定义 A栈
     * while(){
     *
     * 定义B栈
     * 定义C栈
     * 将 A栈 层级节点放入 B栈
     *
     * 清除辅助栈A(为了存放下一层)
     * 然循环辅助栈B
     * 将B栈的元素 按照 层级奇偶 选择正插或者倒插 放入C栈
     * 和
     * 将B栈中节点的子节点正序放入A栈(A栈持有正序儿子)
     *
     *    1
     *  2   3
     * 4 6 7 8
     * 再把,当前辅助栈C栈放入 res
     *
     *
     * }
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>(queue);
            queue.clear();
            Deque<Integer> items = new LinkedList<>();
            for (TreeNode treeNode : temp) {
                if (flag) {
                    items.offerLast(treeNode.val);
                } else {
                    items.offerFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(new ArrayList<>(items));
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        TestDemo3203 testDemo32 = new TestDemo3203();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode5.right = treeNode7;
        treeNode5.left = treeNode6;

        System.out.println(testDemo32.levelOrder(treeNode));
    }
}
