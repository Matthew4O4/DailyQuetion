package _62_圆圈中最后剩下的数字;

import java.util.LinkedList;

/**
 * @Description: -
 * - 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
 * - 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * - 求出这个圆圈里剩下的最后一个数字。
 * <p>
 * - 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * - 从数字0开始每次删除第3个数字
 * - ，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * -
 * - 示例 1：
 * -
 * - 输入: n = 5, m = 3
 * - 输出: 3
 * - 示例 2：
 * -
 * - 输入: n = 10, m = 17
 * - 输出: 2
 * @Author: matthew
 */
public class Test62 {
    /**
     * 首先想到的是双向链表形成环,
     * 或者使用递归逐层减少
     * - 记录每层
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {

        int remaining = 0;
        // 循环中的i表示当前圆圈中剩余元素的数量。最终，当循环结束时，remaining的值就是圆圈中剩余的最后一个元素的索引。
        for (int i = 2; i != n + 1; ++i) {
            // 每次循环，我们将remaining加上m，然后对i取模，这样我们就可以得到下一个要删除的元素的索引
            remaining = (m + remaining) % i;
        }
        return remaining;
    }

}
