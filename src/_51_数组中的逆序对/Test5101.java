package _51_数组中的逆序对;

/**
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 75 76 74 64 54
 * <p>
 * 使用分治 + 归并
 * @Author: matthew
 */
public class Test5101 {
    int[] temp, nums;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        temp = new int[nums.length];
        return reversePairs(0, nums.length - 1);
    }

    public int reversePairs(int l, int r) {
        // 分到根了
        if (l >= r) return 0;
        // 获取中间
        int m = (l - r >> 1) + r;
        // 开始分
        int res = reversePairs(l, m) + reversePairs(m + 1, r);
        // 初始化左右坐标
        int l1 = l, l2 = m + 1;

        // 处理左树
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }

        // 处理并对比右树
        for (int k = l; k <= r; k++) {
            // 如果左树到底了,
            if (l1 == m + 1) {
                // 将右树放入
                nums[k] = temp[l2++];
                // 如果右树到底 或者 左树小于右树
            } else if (l2 == r + 1 || temp[l1] <= temp[l2]) {
                // 将左树放入
                nums[k] = temp[l1++];
                // 如果 左树 > 右树
                // 右树后移
            } else {
                // 将右树放入,并且记录逆序数量
                nums[k] = temp[l2++];
                // 左边的比右边大,所以一次全加完
                res += m - l1 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Test5101 test51 = new Test5101();
//        System.out.println(test51.reversePairs(new int[]{10, 110, 1, 7, 5, 6, 4}));
//        System.out.println(test51.reversePairs(new int[]{7, 5, 6, 4}));
//        System.out.println(test51.reversePairs(new int[]{7, 5, 3, 6, 4, 2}));
//        System.out.println(test51.reversePairs(new int[]{1}));
        System.out.println((10 - 5 >> 1) + 5);

        System.out.println(Integer.toBinaryString((10 - 5) >> 1 + 5));

        System.out.println((5>>6));

        System.out.println((10 - 5) / 2 + 5);

        System.out.println(10 - 5 >> 1 + 5);


    }
}

