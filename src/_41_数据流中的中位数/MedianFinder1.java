package _41_数据流中的中位数;

import java.util.PriorityQueue;

/**
 * @Description: 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * -    奇数就是 中间的数
 * - [2,3,4] 的中位数是 3
 * -    偶数就是 中间数的平均值
 * - [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * -
 * - 设计一个支持以下两种操作的数据结构：
 * -
 * - void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * - double findMedian() - 返回目前所有元素的中位数。
 * - 示例 1：
 * -
 * - 输入：
 * - ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * -      [[],[1],[2],[],[3],[]]
 * - 输出：[null,null,null,1.50000,null,2.00000]
 * - 示例 2：
 * -
 * - 输入：
 * - ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * - [[],[2],[],[3],[]]
 * - 输出：[null,null,2.00000,null,2.50000]
 * - 限制：
 * -
 * - 最多会对 addNum、findMedian 进行 50000 次调用。
 * @Author: matthew
 */
public class MedianFinder1 {

    PriorityQueue<Integer> queueMix;
    PriorityQueue<Integer> queueMax;


    /**
     *
     */
    public MedianFinder1() {
        // 大的在上
        queueMix = new PriorityQueue<>((a, b) -> (b - a));
        // 大的在下
        queueMax = new PriorityQueue<>();
    }

    /**
     * @param num
     */

    public void addNum(int num) {
        // 设第一个为中位数
        if (queueMix.isEmpty() || num <= queueMix.peek()) {
            queueMix.offer(num);
            // 如果大堆差值 > 1 , 将小堆最大元素移动到大堆
            if (queueMax.size() + 1 < queueMix.size()) {
                queueMax.offer(queueMix.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMix.size()) {
                queueMix.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        // 不等于的时候是奇数,中位数为 小堆顶
        if (queueMix.size() > queueMax.size()) {
            return queueMix.peek();
        }
        return (queueMix.peek() + queueMax.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianFinder1 medianFinder = new MedianFinder1();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        // 1 2 3 5   5/2  ->2.5
        System.out.println(medianFinder.findMedian());


        /**
         * 解答成功:
         * 	执行耗时:60 ms,击败了88.88% 的Java用户
         * 	内存消耗:53 MB,击败了5.01% 的Java用户
         */
    }


}
