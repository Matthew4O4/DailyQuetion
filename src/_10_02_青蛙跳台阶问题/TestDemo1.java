package _10_02_青蛙跳台阶问题;

/**
 * @Description: 一次可以跳1阶,也可以跳2阶
 * 0 1 1 2 3 5 8
 * 1
 * 1
 * -
 * 2:2
 * 1 1
 * 2
 * -
 * 3:3
 * 1 1 1
 * 1 2
 * 2 1
 * -
 * 4:5
 * 1 1 1 1
 * 2 1 1
 * 1 2 1
 * 1 1 2
 * 2 2
 * -
 * 5:8
 * 1 1 1 1 1
 * 2 1 1 1
 * 1 2 1 1
 * 1 1 2 1
 * 1 1 1 2
 * 1 2 2
 * 2 1 2
 * 2 2 1
 *
 * @Author: matthew
 * @Date: 2023/1/5 11:30
 */
public class TestDemo1 {
    final int MOD = 1000000007;

    public int numWays(int n) {
        if (n == 0){
            return 1;
        }
        if (n < 2) {
            return n;
        }
        //[0,1,1,2,3,5]
        // 每次持有 前两个
        int a = 0;
        int b = 1;
        int c = 1;
        // 从第三个开始
        // 所以  a = 0
        //       b = c = 1
        // c  = a + b = 1 ->  [index:2 = 1]
        for (int i = 3; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % MOD;
        }
        return c;
    }
}
