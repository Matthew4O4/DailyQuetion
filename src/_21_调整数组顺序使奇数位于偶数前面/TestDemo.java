package _21_调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {


    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // 左右两侧指针
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int j = 0; j < nums.length && right >= left; j++) {
            if ((nums[j] & 1) == 1) {
                res[left] = nums[j];
                left++;
            } else {
                res[right] = nums[j];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(Arrays.toString(testDemo.exchange(new int[]{1, 3, 4, 5, 6, 2, 2, 4})));
    }
}
