package _59_01_滑动窗口的最大值;

import java.util.*;

/**
 * @Description: -
 * - 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * -
 * - 示例:
 * -
 * - 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * - 输出: [3,3,5,5,6,7]
 * - 解释:
 * -
 * -   滑动窗口的位置                最大值
 * - ---------------               -----
 * - [1  3  -1] -3  5  3  6  7       3
 * -  1 [3  -1  -3] 5  3  6  7       3
 * -  1  3 [-1  -3  5] 3  6  7       5
 * -  1  3  -1 [-3  5  3] 6  7       5
 * -  1  3  -1  -3 [5  3  6] 7       6
 * -  1  3  -1  -3  5 [3  6  7]      7
 * - @Author: matthew
 */
public class Test5901 {
    /**
     * 输入数字指定滑动窗口大小,每次取出滑动窗口 大小内最大的数值,循环往后位移
     * 也就是说 如果暴力解的话, 用时 将是  n * k
     * 超时了
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int a = 0, b = k - 1;
        ArrayList<Integer> wi = new ArrayList<>();
        while (b <= nums.length - 1) {
            int layerMax = nums[a];
            for (int i = a; i <= b; i++) {
                layerMax = Math.max(layerMax, nums[i]);
            }
            wi.add(layerMax);
            b++;
            a++;
        }
        int[] res = new int[wi.size()];
        for (int i = 0; i < wi.size(); i++) {
            res[i] = wi.get(i);
        }
        return res;
    }

    /**
     * 维持一个优先队,仍然超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int a = 0, b = k - 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((d, e) -> e - d);
        ArrayList<Integer> list = new ArrayList<>();
        // 填充
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        list.add(priorityQueue.peek());

        while (b < nums.length - 1) {
            priorityQueue.remove(nums[a++]);
            priorityQueue.add(nums[++b]);
            // 加入最大值
            list.add(priorityQueue.peek());
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 优化优先队列
     *
     * @param
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        // 规则,大小一样则对比下标
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((e, d) -> d[0] == e[0] ? d[1] - e[1] : d[0] - e[0]);
        // 填充
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        // 个数
        int[] rest = new int[n - k + 1];
        rest[0] = priorityQueue.peek()[0];
        for (int i = k; i < n; i++) {
            //加入新的值
            priorityQueue.offer(new int[]{nums[i], i});
            // 如果优先队列中的 新值比旧的大, 那旧的就没有必要在队列里了.
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }

            // 将本阶段结果加入 [i(当前下标) - k(起始坐标) + 1()]
            rest[i - k + 1] = priorityQueue.peek()[0];
        }
        return rest;
    }

    /**
     * 单队列
     */
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }




    public static void main(String[] args) {
        Test5901 test5901 = new Test5901();
        System.out.println(Arrays.toString(test5901.maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
