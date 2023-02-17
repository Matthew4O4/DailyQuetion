package _07_重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 看起来更清爽的方案
 * @Author: matthew
 * @Date: 2023/1/4 15:54
 */
public class Recurs2TestDemo {
    Map<Integer, Integer> dic = null;
    int[] preorder;

    TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        dic = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, n - 1);
    }

    //preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
    //inorder =  [4, 5, 8, 10, 9, 3, 15, 20, 7]
    TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        // root -> preorder 的节点
        // 根节点
        TreeNode rootNode = new TreeNode(preorder[root]);

        // subtree-size
        int i = dic.get(preorder[root]);

        rootNode.left = recur(root + 1, left, i - 1);
        // root 当前节点
        // - left 减去从上级循环进入的偏移量
        // + i  偏移数
        // + 1
        rootNode.right = recur(root - left + i + 1, i + 1, right);

        return rootNode;
    }

    public static void main(String[] args) {
        Recurs2TestDemo testDemo = new Recurs2TestDemo();
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        System.out.println(testDemo.buildTree(preorder, inorder));

        Recurs2TestDemo testDemo2 = new Recurs2TestDemo();
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder2 = {9,3,15,20,7};
        System.out.println(testDemo2.buildTree(preorder1, inorder2));
    }
}
