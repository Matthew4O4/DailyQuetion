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
 * <p>
 * 使用分治 + 归并
 * @Author: matthew
 */
public class Test5102 {
    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) >> 1;

        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;

        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];

        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Test5102 test51 = new Test5102();
        System.out.println(test51.reversePairs(new int[]{10, 110, 1, 7, 5, 6, 4}));
        System.out.println(test51.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(test51.reversePairs(new int[]{7, 5, 3, 6, 4, 2}));
        System.out.println(test51.reversePairs(new int[]{1}));
    }
}

