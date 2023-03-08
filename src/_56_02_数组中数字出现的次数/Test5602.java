package _56_02_数组中数字出现的次数;

/**
 * @Description: -
 * -在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * -请找出那个只出现一次的数字。
 * -
 * -示例 1：
 * -
 * -输入：nums = [3,4,3,3]
 * -输出：4
 * -示例 2：
 * -
 * -输入：nums = [9,1,7,9,7,9,7]
 * -输出：1
 * @Author: matthew
 */
public class Test5602 {
    /**
     * '~' 取反
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            // ones ^ num 得到所有不相等的, 再取反 得到
            // 1 ^ 0 = 1   ->  1 & ~0 = 1   one = 1    // 得到 A
            // 1 ^ 0 = 1   ->  1 & ~1 = 0   two = 0    // 得到 B

            // 1 ^ 1 = 0   ->  0 & ~0 = 0 one = 0      // 得到新 A
            // 1 ^ 0 = 1   ->  1 & ~0 = 1 tow = 1      // 得到新 B
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
//        Test5602 test5602 = new Test5602();
//        System.out.println(test5602.singleNumber(new int[]{1, 1, 1, 2, 2, 3, 3, 5, 3, 2}));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(~2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(~3));
        System.out.println(Integer.toBinaryString(3 ^ 1));
        System.out.println(Integer.toBinaryString(1 ^ 1));
        System.out.println(Integer.toBinaryString(0 & ~0));
    }


}
