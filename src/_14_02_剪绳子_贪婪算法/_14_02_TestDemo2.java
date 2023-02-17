package _14_02_剪绳子_贪婪算法;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/8 19:53
 */
public class _14_02_TestDemo2 {
    final int MOD = 1000000007;

    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n < 4) {
            return n - 1;
        }

        long r = 1;
        while (n > 4) {
            r = r * 3 % MOD;
            n -= 3;
        }
        // n 最后为 4,5,6,7
        return (int) (r * n % MOD);
    }

    //953271190
    public static void main(String[] args) {
        _14_02_TestDemo2 a1402TestDemo = new _14_02_TestDemo2();
        System.out.println(a1402TestDemo.cuttingRope(120));
        System.out.println(a1402TestDemo.cuttingRope(127));
        System.out.println(a1402TestDemo.cuttingRope(6));
    }
}

