package _56_01_数组中数字出现的次数;

import java.util.Arrays;

/**
 * @Description: -
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * @Author: matthew
 *
 *
 */
public class Test560102 {

    /**
     * 循环一遍...将只出现一次的持有 如果已存在则移除
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int k = 0, x = 0, y = 0, m = 1;
        // 二进制 两数不相等 时 为1
        // 得到 两个数的异或
        for (int num : nums) {
            k ^= num;
        }

        // 拿到不一样的其中一位二进制
        while ((k & m) == 0) {
            m <<= 1;
        }

        for (int num : nums) {
            if ((num & m) != 0) { // 如果这组数据特征符合 x
                x ^= num;

            } else {  // 否则这组数据特征符合 y
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Test560102 test5601 = new Test560102();
        System.out.println(Arrays.toString(test5601.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

}
