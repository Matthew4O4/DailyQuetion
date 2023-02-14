package _42_连续子数组的最大和;

/**
 * @Description: 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Author: matthew
 */
public class TestDemo42 {

    /**
     * 4,-1,2,1
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            // 对比加完当前坐标之后的累加和 和 单独的当前值谁更大,如果累加和不大于当前值则替换为新值
            pre = Math.max(pre + num, num);
            max = Math.max(max,pre);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TestDemo42().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
