package _10_01_斐波那契数列;

/**
 * @Description: 递推 使用内存最少
 * <p>
 * 1 1 2 3 5 8
 * @Author: matthew
 * @Date: 2023/1/5 10:38
 */
public class TestDemo3 {
    final int MOD = 1000000007;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        //[1,1,2,3,5]
        // 每次持有 前两个
        int a = 0;
        int b = 0;
        int c = 1;
        // 从第三个开始
        // 所以  a = 0
        //       b = c = 1
        // c  = a + b = 1 ->  [index:2 = 1]
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % MOD;
        }
        return c;
    }


    public static void main(String[] args) {
        TestDemo3 testDemo3 = new TestDemo3();
        System.out.println(testDemo3.fib(4));
    }
}
