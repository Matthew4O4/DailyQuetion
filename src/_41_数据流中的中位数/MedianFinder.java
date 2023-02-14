package _41_数据流中的中位数;

import java.util.ArrayList;

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
public class MedianFinder {


    /**
     * initialize your data structure here.
     * <p>
     * 中位数: 首先是有序的,其次是平衡的
     * 二叉搜索平衡树
     * 如果是偶数 -> 左右节点的值即可
     * 如果是奇数 -> 根节点的值即可
     * <p>
     * 或者是:
     * 有序数组...
     * 插入时不排序
     * 查找时排序
     * 如果上次排序后未被改变则不排序
     * -        2
     * -    1       3
     * -
     * -
     */
    public MedianFinder() {
        this.list = new ArrayList<>();
    }

    ArrayList<Integer> list;

    boolean flag;

    // true奇数 false偶数
    boolean type;

    public void addNum(int num) {
        list.add(num);
        if (flag) {
            this.flag = false;
        }
        type = !type;
    }

    public double findMedian() {

        if (list.size() == 1) {
            return list.get(0);
        }
        if (!flag) {
            list.sort(null);
            this.flag = true;
        }

        int index = (list.size() >> 1) - 1;
        if (type) {
            return list.get(index + 1);
        } else {
            double i = list.get(index) + list.get(index + 1);
            return i / 2;
        }
    }

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(1);
//        linkedList.add(3);
//        linkedList.add(-10);
//        linkedList.sort(null);
//        System.out.println(linkedList);
//        System.out.println(5 << 1);
//        System.out.println(1 >> 1);

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(5);

        System.out.println(medianFinder.findMedian());


        /**
         * 解答成功:
         * 	执行耗时:1758 ms,击败了5.01% 的Java用户
         * 	内存消耗:51.1 MB,击败了98.80% 的Java用户
         */
    }


}
