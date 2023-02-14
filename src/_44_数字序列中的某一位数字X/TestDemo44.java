package _44_数字序列中某一位的数字;

/**
 * @Description: 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 0123456789 1 0 1 1 1 2 1 3 1 4 1 5
 * <p>
 * 13  15
 * <p>
 * <p>
 * 个位:输入 即 输出
 * 十位: 个位: target - res个位数  ->   11 - 1 = 10
 * 十位: 个位: target - res个位数  ->   12 - 1 = 11
 * <p>
 * <p>
 * 11 -> 0
 * 12 -> 1
 * 13 -> 1
 * 14 -> 1
 * 15 -> 2
 * 16 -> 1
 * 17 -> 3
 * 18 -> 1
 * 19 -> 4
 * 20 -> 1
 * 21 -> 5
 * 22 -> 1
 * <p>
 * <p>
 * 1000
 * <p>
 * <p>
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * @Author: matthew
 */
public class TestDemo44 {

    public int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 25535; i++) {
            stringBuilder.append(i);
        }
        return Integer.valueOf(stringBuilder.substring(n, n + 1));
    }

    public int findNthDigit2(int n) {
        //个位 对等
        int q = 0;
        if (n<10){
            return n;
        }
        //        ↓
        // 11 -> 10 11
        //          ↓
        // 12 -> 10 11 12

        return 0;
    }

    public static void main(String[] args) {
        TestDemo44 testDemo = new TestDemo44();
        System.out.println(testDemo.findNthDigit(0));
        System.out.println(testDemo.findNthDigit(10));
        System.out.println(testDemo.findNthDigit(11));
        System.out.println(testDemo.findNthDigit(12));
        System.out.println(testDemo.findNthDigit(13));
        System.out.println(testDemo.findNthDigit(997));
        System.out.println(Math.pow(2, 31));
    }
}
