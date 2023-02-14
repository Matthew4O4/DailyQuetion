package _39_数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo3901 {

    /**
     * 无论如何,肯定会超过一半,不管是前半段还是后半段
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
