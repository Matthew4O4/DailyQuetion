package _49_丑数;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Description: -
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * 输入: n = 10 输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12,  是前 10 个丑数。
 * @Author: matthew
 */
public class TestDemo4901 {

    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }

        int[] arr = {2, 5, 3};

        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> dic = new HashSet<>();
        queue.offer(1l);
        int cur = 0;

        // 循环
        for (int k = 0; k < n; k++) {
            long poll = queue.poll();
            cur = (int) poll;
            for (int base : arr) {
                // 得到 素数相乘的结果
                long a = base * poll;
                // 如果字典里没有则加入
                if (dic.add(a)) {
                    queue.offer(a);
                }
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        TestDemo4901 testDemo49 = new TestDemo4901();
        System.out.println(testDemo49.nthUglyNumber(10));
        System.out.println(testDemo49.nthUglyNumber(11));
        System.out.println(testDemo49.nthUglyNumber(15));
        System.out.println(testDemo49.nthUglyNumber(709));
    }
}
