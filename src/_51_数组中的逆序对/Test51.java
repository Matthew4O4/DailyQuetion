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
 *
 * 超时了...
 *
 *
 *
 * @Author: matthew
 */
public class Test51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        // 遍历 从第一个数开始往后遍历
        for (int i = 0; i < nums.length; i++) {
            // 第二层
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test51 test51 = new Test51();
        System.out.println(test51.reversePairs(new int[]{10, 110, 1, 7, 5, 6, 4}));
        System.out.println(test51.reversePairs(new int[]{1}));
    }
}

