package _57_01_和为s的两个数字;

import java.util.Arrays;

/**
 * @Description: - 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * - 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * -
 * -
 * @Author: matthew
 * 超时了
 */
public class Test57 {

    /**
     * - 递增数组, 每组数据往后加
     * - 如果当前数值单个 > target 则抛弃
     * - 如果当前数值 + next > target 则抛弃
     *
     * 超时了
     */

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        if (nums[nums.length - 2] + nums[nums.length - 1] < target) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                    return res;
                }
                if (nums[i] > target) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test57 test57 = new Test57();
        System.out.println(Arrays.toString(test57.twoSum(new int[]{1, 2, 3, 4}, 0)));
    }

}
