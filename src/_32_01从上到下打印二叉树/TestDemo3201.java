package _32_01从上到下打印二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 1
 * 2  3
 * 4 5
 * <p>
 * 每一层都要横向加入
 * @Author: matthew
 */
public class TestDemo3201 {
    ArrayList<Integer> res;
    /**
     * 每次将一层先压入队列
     */
    Queue<TreeNode> queue;

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        queue = new ArrayDeque<>();
        res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            rec1();
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    /**
     * 遍历队列里的子,并把他们的子加入队列
     *
     * @param
     */
    void rec1() {
        ArrayList<TreeNode> temp = new ArrayList<>(queue);
        queue.clear();
        for (TreeNode treeNode : temp) {
            res.add(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * 更高效的方式
     * @param root
     * @return
     */
    public int[] levelOrderUUUU(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> qu = new LinkedList<>();
        LinkedList<Integer> resList = new LinkedList();
        qu.add(root);

        while (!qu.isEmpty()) {
            TreeNode poll = qu.poll();
            if (poll == null) {
                continue;
            }
            resList.add(poll.val);
            qu.add(poll.left);
            qu.add(poll.right);
        }
        int[] res  = new int[resList.size()];
        int i =0;
        for(Integer item : resList){
            res[i++] = item;
        }
        return res;
    }





    public static void main(String[] args) {
        TestDemo3201 testDemo32 = new TestDemo3201();
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
