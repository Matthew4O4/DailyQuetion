package _53_01_在排序数组中查找数字;

/**
 * @Description: 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * @Author: matthew
 */
public class Test5301 {

    int k;

    // 数组是有序的
    // 可以通过2分来找到这个数
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }
        k = 0;
        mySearch(nums, 0, nums.length - 1, target);
        return k;
    }

    /**
     * 先查左边的如果区间不包含则退出
     *
     * @return
     */
    void mySearch(int[] nums, int a, int b, int target) {
        if (k != 0 || a < 0 || b > nums.length - 1 || nums[a] > target || nums[b] < target) return;
        int min = (b - a >> 1) + a;
        if (nums[min] == target) {
            getNumber(nums, min, target);
            return;
        }
        if (target > nums[min]) {
            mySearch(nums, min + 1, b, target);
        } else if (target < nums[min]) {
            mySearch(nums, a, min - 1, target);
        }
    }

    private void getNumber(int[] nums, int min, int target) {
        int c = min;

        while (c < nums.length && nums[c] == target) {
            k++;
            c++;
        }
        c = min - 1;
        while (c >= 0 && nums[c] == target) {
            k++;
            c--;
        }
    }

    public static void main(String[] args) {
        Test5301 test5301 = new Test5301();
//        System.out.println((4 - 2 >> 1) + 2);
        System.out.println(test5301.search(new int[]{1,1, 2}, 1));
    }
}
