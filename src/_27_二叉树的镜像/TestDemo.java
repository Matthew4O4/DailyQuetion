package _27_二叉树的镜像;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {


    // 采用中序遍历的方式
    public TreeNode mirrorTree(TreeNode root) {
        //每个节点左右对调
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.right);
        mirrorTree(root.left);
        return root;
    }


    public static void main(String[] args) {
    }
}
