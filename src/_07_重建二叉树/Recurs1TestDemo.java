package _07_重建二叉树;

import java.util.HashMap;

/**
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7],inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * @Author: matthew
 * @Date: 2023/1/4 09:40
 */
public class Recurs1TestDemo {
    public HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        // 终止条件:代表已经越过叶子节点.
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 前序遍历第一个元素是当前根节点,持有根节点是为了 找到左右树
        int preorderRoot = preorderLeft;
        // 找到中序遍历的根节点所在位置,前序遍历中的根节点 在中序遍历中其左右两侧为左右子树的根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        // 新建根节点
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 得到左子树的节点数量
        int size_left_subtree = inorderRoot - inorderLeft;
        // 递归构建左子树,并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素
        // 就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        //preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
        //inorder =  [4, 5, 8, 10, 9, 3, 15, 20, 7]
        //-----//
        //preorder = [9, 8, 5, 4, 10]
        //inorder = [4, 5, 8, 10, 9]
        root.left = myBuildTree(preorder, // 前序遍历
                inorder, // 中序遍历
                preorderLeft + 1, // 左子:当前根节点+1
                preorderLeft + size_left_subtree, // 左子右边界:也就是当前节点的 左子节点数量
                inorderLeft, // 中序遍历的左节点
                inorderRoot - 1 // 中序遍历的右节点
        );
        //preorder = [20, 15, 7]
        //inorder = [15, 20, 7]
        root.right = myBuildTree(preorder, //
                inorder, //
                preorderLeft + size_left_subtree + 1, //
                preorderRight, //
                inorderRoot + 1, //
                inorderRight //
        );
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 获取元素个数
        int n = preorder.length;
        // 构建哈希映射,可以根据值确定下标

        for (int i = 0; i < n; i++) {
            // 中序遍历,可以根据根节点找到左右子树
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        Recurs1TestDemo recurs1TestDemo = new Recurs1TestDemo();
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        System.out.println(recurs1TestDemo.buildTree(preorder, inorder));

        int[] preorder1 = {3,9,20,15,7};
        int[] inorder2 = {9,3,15,20,7};
        System.out.println(recurs1TestDemo.buildTree(preorder1, inorder2));

    }
}
