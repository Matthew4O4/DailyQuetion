package _55_01_二叉树的深度;

/**
 * @Description: - 输入一棵二叉树的根节点，求该树的深度。
 * - 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * -
 * - 例如：
 * -
 * - 给定二叉树 [3,9,20,null,null,15,7]，
 * -
 * -     3
 * -    / \
 * -   9  20
 * -     /  \
 * -    15   7
 * - 返回它的最大深度 3 。
 * @Author: matthew
 */
public class Test5501 {
    /**
     * 深度就是 找到最深的树树.
     * 最深的树树,需要走每个点呢
     *
     * @param root
     * @return
     */
    int k;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        k = 1;
        myMaxDepth(root, 1);
        return k;
    }

    public void myMaxDepth(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            k = Math.max(i, k);
            return;
        }
        // 采用深度遍历
        myMaxDepth(root.left, i + 1);

        myMaxDepth(root.right, i + 1);
    }

    public static void main(String[] args) {
        Test5501 test5501 = new Test5501();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.right = treeNode3;
        System.out.println(test5501.maxDepth(null));
    }
}
