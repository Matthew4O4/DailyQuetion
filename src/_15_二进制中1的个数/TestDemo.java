package _15_二进制中1的个数;

/**
 * @Description:  此方案负数时会导致无限循环  0x80  -> 0xFF
 * @Author: matthew
 * @Date: 2023/1/10 10:13
 */
public class TestDemo {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.hammingWeight(9));
        System.out.println(StrictMath.pow(10, -1));
        System.out.println(StrictMath.pow(10, -2));
        System.out.println(StrictMath.pow(1, -8));
        System.out.println(StrictMath.pow(10, 1));
        System.out.println(StrictMath.pow(10, 2));
    }

}
