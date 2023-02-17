package _15_二进制中1的个数;

/**
 * @Description: 9 -> 1100
 * 9 - 1 -> 1011
 * 9 & 8 -> 1000
 * ∵  把一个整数 -1 ,再和原来的数做位运算, 就会把该整数最右边一个1变成0.
 * ∴  一个数能进行几次这个操作后不为0 则表示有多少位1 呢
 * @Author: matthew
 * @Date: 2023/1/10 10:25
 */
public class TestDemo1 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        TestDemo1 testDemo = new TestDemo1();
        System.out.println(testDemo.hammingWeight(9));
    }

}
