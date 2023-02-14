package _40_最小的k个数;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @Description:
 * @Author: matthew
 */
public class TestDemo40 {
    /**
     * 最小的k个数
     * 使用双向队列 ->
     * k 2
     * 3 1 2 3 4
     * 3
     * 3 1
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        // 排序后 前k 个数即可
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }

    public static void main(String[] args) {
        TestDemo40 testDemo40 = new TestDemo40();
        System.out.println(Arrays.toString(testDemo40.getLeastNumbers(new int[]{4,1, 2, 3}, 3)));
    }
}
