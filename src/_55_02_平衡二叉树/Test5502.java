package _55_02_平衡二叉树;


/**
 * @Description: -
 * -输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * -如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @Author: matthew
 */
public class Test5502 {

    class MyI {
        Integer i = 0;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        MyI myI = new MyI();
        return myIsBalanced(root, myI);
    }
    // 只要其左右深度不大于1 即可
    public boolean myIsBalanced(TreeNode root, MyI di) {
        if (root == null) {
            di.i = 0;
            return true;
        }

        MyI leftI = new MyI();
        MyI rightI = new MyI();


        // 如果左树和右树深度相差不大于 1 即可
        boolean left = myIsBalanced(root.left, leftI);
        boolean right = myIsBalanced(root.right, rightI);

        if (left && right) {
            // 判断深度是否小于1
            if (Math.abs(rightI.i - leftI.i) <= 1) {
                // 如果小于一则没有超限 ,需要更新进场 I 的层数.
                di.i += 1 + Math.max(rightI.i, leftI.i);
                // 返回符合
                return true;
            }
        }
        return false;
    }

    /**
     * -      t1
     * -  t2     t3
     * -t4
     * -   t5
     *
     * @param args
     */
    public static void main(String[] args) {
        Test5502 test5502 = new Test5502();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t3.right = t5;

        System.out.println(test5502.isBalanced(t1));
    }
}
