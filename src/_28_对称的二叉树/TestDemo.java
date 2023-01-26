package _28_对称的二叉树;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        if ((root.left == null || root.right == null) && root.right != root.left) {
            return false;
        }
        return checkIsSome(root.left, root.right);
    }

    boolean checkIsSome(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val && checkIsSome(a.left, b.right) && checkIsSome(a.right, b.left);
    }

}
