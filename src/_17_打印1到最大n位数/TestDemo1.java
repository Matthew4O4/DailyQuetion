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
public class TestDemo1 {
    int[] res;
    int count;

    // 打印 输入数的最大长度串
    int[] max(int n) {
        if (n <= 0)
            return new int[0];

        // 实际的记录
        res = new int[(int) Math.pow(10, n) - 1];

        // 长度 n = 3 ->  1 2 3
        for (int i = 1; i < n + 1; i++) {
            // 数值
            for (char j = '1'; j <= '9'; j++) {
                char[] dir = new char[i];
                dir[0] = j;
                myMax(1, dir, i);
            }
        }
        return res;
    }

    /**
     *
     * @param index
     * @param dir
     * @param i
     */
    void myMax(int index, char[] dir, int i) {

        if (index == i) {
            res[count++] = Integer.parseInt(String.valueOf(dir));
            return;
        }

        for (char j = '0'; j <= '9'; j++) {
            // 0 ,
            dir[index] = j;
            myMax(index + 1, dir, i);
        }

    }


    public static void main(String[] args) {
        TestDemo1 testDemo = new TestDemo1();
        System.out.println(Arrays.toString(testDemo.max(2)));
    }

}
