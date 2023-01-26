package _26_树的子结构;

/**
 * @Description: 查找 A 树 中 是否存在B 子树
 * @Author: matthew
 */
public class TestDemo {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null && (check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    private boolean check(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

}
