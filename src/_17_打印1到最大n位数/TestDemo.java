package _17_打印1到最大n位数;

import java.util.Arrays;

/**
 * @Description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * @Author: matthew
 */
public class TestDemo {
    // 打印 输入数的最大长度串
    int[] max(int n) {
        if (n <= 0)
            return new int[0];

        // n = 3 ->  1...999
        int x = (int) Math.pow(10, n) - 1;
        int[] res = new int[x];
        int le = x - 1;

        // 每次处理两头,处理一半即可
        int le_2 = le >> 1;
        // 先处理中间值
        res[le_2] = le_2 + 1;

        for (int i = 0; i < le_2; i++) {
            res[i] = i + 1;
            res[le - i] = le - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(Arrays.toString(testDemo.max(2)));
    }

}
