package _33_二叉搜索树的后续遍历序列;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    // 二叉树 3 4 5 7 8 6

    /**
     *                  6
     *              4        7
     *          3      5        8
     *
     *          每个数节点的            [A小于rootB][C大于rootD][Eroot]
     *          E = [len
     *          A = [left
     *          B = [C - 1
     *          C = [indexOf(x) > [E
     *          D = len - 1
     *
     */

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int startb = start;
        // 前半段 < root
        while (postorder[startb] < postorder[end]) startb++;
        // 获取左子树的end节点
        int endb = startb;
        // 后半段 > root
        while (postorder[startb] > postorder[end]) startb++;

        // 如果前半段+后半段到达不了 end 说明 有问题.
        return startb == end &&
                // 验证前半段是否遵循此规律
                verifyPostorder(postorder, start, endb - 1)
                &&
                // 验证后半段是否遵循此规律
                verifyPostorder(postorder, endb, end - 1);
    }

    public static void main(String[] args) {
        TestDemo33 testDemo33 = new TestDemo33();
        System.out.println(testDemo33.verifyPostorder(new int[]{1, 6, 3, 2, 5})); //12345 ex: true | print: false
    }

    /**
     * 思路
     * 搜索二叉树的特点是
     * 每个节点都是   [小于root的N个节点]+[大于root的N个节点]+root 节点组成, 可以没有 小于的,也可以没有大于的.
     * 每次判断 < root 的节点和 和 > root 的节点和 之 和 + 1 是否等于 root 节点下标即可.
     * 也就是说数量对了,就再往下切分.
     * 往复循环即可.
     */
}

