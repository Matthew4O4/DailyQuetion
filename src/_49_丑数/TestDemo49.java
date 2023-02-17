package _49_丑数;

import java.util.HashMap;

/**
 * @Description: -
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * 输入: n = 10 输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12,  是前 10 个丑数。
 * @Author: matthew
 */
public class TestDemo49 {
    HashMap<Integer, Boolean> map;

    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        this.map = new HashMap<>();

        int i = 7;
        // 循环
        for (int k = 7; k <= n; i++) {
            if (haveSmn(i)) {
                k++;
            }
        }
        return i - 1;
    }

    boolean haveSmn(int i) {
        if (map.containsKey(i)) return map.get(i);
        if (i == 1) {
            return true;
        }
        // 查看小数点后是否为0
        if (i / 2 == ((double) i / 2)) {
            boolean b = haveSmn(i / 2);
            map.put(i, b);
            return b;
        } else if (i / 3 == ((double) i / 3)) {
            boolean b = haveSmn(i / 3);
            map.put(i, b);
            return b;
        } else if (i / 5 == ((double) i / 5)) {
            boolean b = haveSmn(i / 5);
            map.put(i, b);
            return b;
        } else {
            map.put(i, false);
            return false;
        }
    }

    public static void main(String[] args) {
        TestDemo49 testDemo49 = new TestDemo49();
        System.out.println(testDemo49.nthUglyNumber(10));
        System.out.println(testDemo49.nthUglyNumber(11));
        System.out.println(testDemo49.nthUglyNumber(15));
        System.out.println(testDemo49.nthUglyNumber(709));
    }
}
