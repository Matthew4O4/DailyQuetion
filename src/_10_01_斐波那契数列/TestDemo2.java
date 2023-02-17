package _10_01_斐波那契数列;

import java.util.HashMap;
import java.util.Locale;

/**
 * @Description: 加入词典,效率大大提升 > TestDemo1
 * <p>
 * 0 1 1 2 3 5 8
 * @Author: matthew
 * @Date: 2023/1/5 10:38
 *
 *
 */
public class TestDemo2 {

    public  HashMap<Integer, Integer> dic = new HashMap<>();
    final  int MOD =1000000007;
    public  int fib(int n) {
        if (n < 2) {
            return n;
        }

        if (dic.get(n) != null) {
            return dic.get(n);
        }

        int i = (fib(n - 1) + fib(n - 2)) % MOD;
        dic.putIfAbsent(n, i);
        return i;
    }


    public static void main(String[] args) {
        TestDemo2 testDemo2 = new TestDemo2();
        System.out.println(testDemo2.fib(45));
    }
}
