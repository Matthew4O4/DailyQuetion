package _39_数组中出现次数超过一半的数字;

import java.util.HashMap;

/**
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @Author: matthew
 */
public class TestDemo39 {

    /**
     * 弄个HashMap 去记录数据
     */
    public int majorityElement(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> dic = new HashMap<>();
        int halfPastTwo = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (dic.containsKey(nums[i])) {
                int sum = dic.get(nums[i]) + 1;
                dic.put(nums[i], sum);
                if (halfPastTwo < sum) {
                    return nums[i];
                }
            } else {
                dic.put(nums[i], 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TestDemo39 testDemo39 = new TestDemo39();
        System.out.println(testDemo39.majorityElement(new int[]{}));
    }
}
