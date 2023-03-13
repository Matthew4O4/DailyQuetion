package _68_02_二叉搜索树的最近公共祖先;

/**
 * @Description: -
 * 本版本非 搜索二叉树
 * 采用递归的方式
 * 从底层开始,当遇到两个都有的时候则说明找到公共树了
 * @Author: matthew
 */
public class Test6802 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode res;
        res = lowestCommonAncestor(root.left, p, q);
        if (res == null) {
            res = lowestCommonAncestor(root.right, p, q);
        }
        if (res == null && isHave(root, p) && isHave(root, q)) {
            res = root;
        }
        return res;
    }

    public boolean isHave(TreeNode cur, TreeNode selectNode) {
        if (cur == null) return false;
        if (cur.val == selectNode.val) return true;
        return isHave(cur.left, selectNode) || isHave(cur.right, selectNode);
    }


    public static void main(String[] args) {
        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);

        t3.left = t5;
        t5.left = t6;
        t5.right = t2;

        t3.right = t1;
        t1.left = t0;
        t1.right = t8;

        t2.left = t7;
        t2.right = t4;

        Test6802 test6802 = new Test6802();
        System.out.println(test6802.lowestCommonAncestor(t3, t0, t8).val);


    }
}
