package _10_01_斐波那契数列;

/**
 * @Description: 一个不够好的递归实现
 * <p>
 * 0 1 1 2 3 5 8
 * @Author: matthew
 * @Date: 2023/1/5 10:38
 */
public class TestDemo1 {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int i = fib(n - 1) + fib(n - 2);
        System.out.println(i);
        return i;
    }


    public static void main(String[] args) {
        System.out.println(fib(8));
    }
}
