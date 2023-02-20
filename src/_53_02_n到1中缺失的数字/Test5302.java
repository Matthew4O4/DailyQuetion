package _53_02_n到1中缺失的数字;

/**
 * @Description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * <p>
 * <p>
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * @Author: matthew
 */
public class Test5302 {

    /**
     * 0~ n-1 的递增数组中, 每个数字不重复,且每个数字都在范围内 ->
     * <p>
     * 1234
     * 3
     * 124
     * 循环遍历  不连贯的则为丢失的数
     * 二分
     * 1 ~ min .size  = min - i
     * 如果不是则说明这段有问题
     * 否则就是另一端
     *
     * @param nums
     * @return
     */
    int k;

    public int missingNumber(int[] nums) {
        k = 0;
        if (nums == null || nums.length == 0 || nums[0] != 0) {
            return k;
        }

        if (nums.length == nums[nums.length - 1] - nums[0] + 1) return nums[nums.length - 1] + 1;

        missingNumber(nums, 0, nums.length - 1);
        return k;
    }

    public void missingNumber(int[] nums, int l, int r) {
        //
        if (l == r || l < 0 || r > nums.length) {
            k = nums[l] - 1;
            return;
        }

        if (r - l == 1 && nums[r] - nums[l] != 1) {
            k = nums[l] + 1;
            return;
        }

        int min = l + (r - l >> 1);
        if (r - min != nums[r] - nums[min]) {
            missingNumber(nums, min + 1, r);
        } else {
            missingNumber(nums, l, min);
        }

    }

    public static void main(String[] args) {
        Test5302 test5302 = new Test5302();
        System.out.println(test5302.missingNumber(new int[]{0, 2, 3}));
        System.out.println(test5302.missingNumber(new int[]{0}));
        System.out.println(test5302.missingNumber(new int[]{2}));
        System.out.println(test5302.missingNumber(new int[]{2,4,5}));
        //                                                  0  1  2
    }
}
