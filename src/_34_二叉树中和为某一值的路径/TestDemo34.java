package _34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * 1
 * 2   3
 * 4  5
 * @Author: matthew
 */
public class TestDemo34 {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        pathSum(root, target, new ArrayList<>(), 0);
        return res;
    }

    public boolean pathSum(TreeNode root, int target, List<Integer> treeNodesValue, int currentSum) {

        if (root == null) {
            return false;
        }

        boolean flag = false;
        currentSum += root.val;
        treeNodesValue.add(root.val);
        // == 是要判断当前节点是否为有叶子节点
        if (target == currentSum && root.left == null && root.right == null) {
            ArrayList<Integer> integers = new ArrayList<>(treeNodesValue);
            res.add(integers);
            flag = true;
        }

        // 如果 < 则 需要继续向下寻找
        boolean aflag = pathSum(root.left, target, treeNodesValue, currentSum);
        boolean bflag = pathSum(root.right, target, treeNodesValue, currentSum);
        if (aflag || bflag) {
            flag = true;
        }

        treeNodesValue.remove(treeNodesValue.size() - 1);
        return flag;
    }

    public static void main(String[] args) {
        TestDemo34 testDemo33 = new TestDemo34();
        TreeNode treeNode1 = new TreeNode(-2);
//        TreeNode treeNode2 = new TreeNode(-3);
        TreeNode treeNode3 = new TreeNode(-3, null, treeNode1);
//        TreeNode treeNode33 = new TreeNode(5, null, null);
//        TreeNode treeNode4 = new TreeNode(4, treeNode2, treeNode33);
//        TreeNode treeNode5 = new TreeNode(5, treeNode3, null);
//        TreeNode treeNode6 = new TreeNode(6, treeNode5, treeNode4);


        System.out.println(testDemo33.pathSum(treeNode3, -5));
    }

}
