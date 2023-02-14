package _37_序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * <p>
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * }
 * @Author: matthew
 */
public class TestDemo3701 {
    // Encodes a tree to a single string.
    final String NULL = "null";
    final String SEP = ",";

    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder resStr = new StringBuilder();
        qu.offer(root);

        while (!qu.isEmpty()) {
            TreeNode poll = qu.poll();
            if (poll == null) {
                resStr.append(NULL).append(SEP);
                continue;
            }
            resStr.append(poll.val).append(SEP);
            qu.offer(poll.left);
            qu.offer(poll.right);
        }
        return resStr.substring(0, resStr.length() - 1);
    }


    /**
     * 反序列化
     * 1,2,3,null,null,4,5
     * 1    1 -> 2^0
     * 2    2 -> 2^1
     * 3    4 -> 2^2
     * 4    8 -> 2^3
     * 5    16-> 2^4
     * 2 * 2 * 2 * 2 + 1
     * <p>
     * -                1
     * -          2            n
     * -     3       4      n       n
     * -  n   n    n   n  n   n   n    n
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] nodes = data.split(SEP);

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 记录父节点
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        // i 从 1 开始,one loop plus 2;
        for (int i = 1; i < nodes.length; ) {
            String left = nodes[i++];
            // 根据规则 出队列的一定是 实例
            TreeNode temp = que.poll();
            if (!NULL.equals(left)) {
                temp.left = new TreeNode(Integer.parseInt(left));
                que.offer(temp.left);
            }
            String right = nodes[i++];
            if (!NULL.equals(right)) {
                temp.right = new TreeNode(Integer.parseInt(right));
                que.offer(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
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
//        treeNode5.right = treeNode7;
//        treeNode5.left = treeNode6;
        TestDemo3701 testDemo37 = new TestDemo3701();
//        System.out.println(testDemo37.serialize(treeNode));
        System.out.println(testDemo37.deserialize("1,2,3,null,null,4,5"));

    }
}
