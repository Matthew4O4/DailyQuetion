package _65_不用加减乘除做加法;

/**
 * @Description: -
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * @Author: matthew
 */
public class Test65 {
    /*
        第一位是标志位
        如果为1则是复数
        如果为0则是正数
        1 + -1 = 0

        1 = 0001
       -1 = 1111
        0 = 0000


        4 + -5 = -1
        100
        11111111111111111111111111111011

        1 + 2 = 3
        1 = 0001
        2 = 0010
        3 = 0011

        4 + 4 = 8
        4 = 100
        8 = 1000
        两个32位数组

        // 不管进位的话,两数相加 等与 两数的 &
        0 + 1 = 1 + 0 = 1;
        // 我们循环处理进位即可
        1 + 1 = (1)0;
     */


    public int add(int a, int b) {
        //
        if (b == 0) return a;
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(3 << 1));
        System.out.println(Integer.toBinaryString(3 << 1 << 1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(8));
        System.out.println("----");
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(Integer.toBinaryString(-7));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-11));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

}
