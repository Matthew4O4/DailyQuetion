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
public class Test5701 {

    /**
     * 双指针
     * 如果当前数 > target 则右回
     * 如果当前数 < target 则左进
     */

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i]+nums[j];
            if (s >target) j--;
            else if (s<target)i++;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Test5701 test57 = new Test5701();
        System.out.println(Arrays.toString(test57.twoSum(new int[]{1, 2, 3, 4}, 4)));
    }

}
