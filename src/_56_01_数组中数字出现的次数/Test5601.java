package _56_01_数组中数字出现的次数;

import java.util.Arrays;
import java.util.HashSet;

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
 */
public class Test5601 {

    /**
     * 循环一遍...将只出现一次的持有 如果已存在则移除
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> objects = new HashSet<>();
        for (int num : nums) {
            if (objects.add(num)) {
            } else {
                objects.remove(num);
            }
        }

        int[] res = new int[2];
        int i = 0;
        for (Integer object : objects) {
            res[i++] = object;
        }
        return res;
    }

    public static void main(String[] args) {
        Test5601 test5601 = new Test5601();
        System.out.println(Arrays.toString(test5601.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

}
