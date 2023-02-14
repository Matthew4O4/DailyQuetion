package _32_02从上到下打印二叉树;


import java.util.*;

/**
 * @Description: 1
 * 2  3
 * 4 5
 * <p>
 * 每一层都要横向加入
 * @Author: matthew
 */
public class TestDemo3202 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>(queue);
            queue.clear();
            ArrayList<Integer> items = new ArrayList<>();

            for (TreeNode treeNode : temp) {
                items.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (flag) {
                Stack<Integer> stackItem = new Stack<>();
                stackItem.addAll(items);
                items.clear();
                while (!stackItem.isEmpty()) {
                    items.add(stackItem.pop());
                }
            }
            res.add(items);
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        TestDemo3202 testDemo32 = new TestDemo3202();
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
