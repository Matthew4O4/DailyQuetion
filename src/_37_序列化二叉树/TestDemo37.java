package _37_序列化二叉树;

import java.util.ArrayList;
import java.util.List;

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
 *
 *
 * TTTTTTTTT:力扣超时!  我干
 */
public class TestDemo37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 下层
        List<TreeNode> currentRoots = new ArrayList<>();
        currentRoots.add(root);
        StringBuilder resStr = new StringBuilder();

        while (true) {
            ArrayList<TreeNode> list = new ArrayList<>(currentRoots);
            currentRoots.clear();
            int k = 0;
            //当前层
            for (TreeNode temp : list) {
                if (temp == null) {
                    resStr.append("null");
                    currentRoots.add(null);
                    currentRoots.add(null);
                } else {
                    // 填充下层
                    resStr.append(temp.val);
                    currentRoots.add(temp.left);
                    currentRoots.add(temp.right);
                    if (temp.right != null || temp.left != null) {
                        k++;
                    }
                }
                resStr.append(",");
            }
            // 为0说明下层全是空,该毁灭了
            if (k == 0) {
                list.clear();
                currentRoots.clear();
                break;
            }
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
        String[] split = data.split(",");
        TreeNode node = new TreeNode(Integer.valueOf(split[0]));

        int length = split.length;
        // 层数
//        int lay = (int) (Math.log(length) / Math.log(2.0));
        // 当前层
//        int curLay = 0;
        // 前一个节点 End

        ArrayList<TreeNode> currentList = new ArrayList<>();
        ArrayList<TreeNode> nextList = new ArrayList<>();
        currentList.add(node);
        int start = 1;

        for (; start < length; ) {
            // 当前结尾
//            int stop = (int) Math.pow(2, lay);
            for (TreeNode treeNode : currentList) {
                if (treeNode == null) {
//                    start += 2;
                    continue;
                }
                // 左右节点
                for (int a = 0; a < 2 && start<length; a++, start++) {
                    String str = split[start];
                    if ("null".equals(str)) {
                        nextList.add(null);
                    } else {
                        TreeNode temp = new TreeNode(Integer.parseInt(str));
                        if (a == 0) {
                            treeNode.left = temp;
                        } else {
                            treeNode.right = temp;
                        }
                        nextList.add(temp);
                    }
                }
            }
            /**
             * 当前层已创建,创建下层
             */
            currentList.clear();
            currentList.addAll(nextList);
            nextList.clear();
        }
        return node;
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
        TestDemo37 testDemo37 = new TestDemo37();
        System.out.println(testDemo37.serialize(treeNode));
        System.out.println(testDemo37.deserialize("1,2,3,null,null,4,5"));

    }
}
