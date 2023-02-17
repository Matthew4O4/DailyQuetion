package _14_02_剪绳子_贪婪算法;

/**
 * @Description: 使用贪婪算法
 * @Author: matthew
 * @Date: 2023/1/8 19:06
 */
public class _14_02_TestDemo {

    final int MOD = 1000000007;


    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;//1 x
        }
        if (n == 2) {
            return 1;//1 *1
        }
        if (n == 3) {
            return 2; //1 *2
        }
        // 3 是最优秀的元素,看看能分几个三
        int timesOf3 = n / 3;

        // 但是为 4 的时候就不要再分了 因为 4 -> 3 1 -> 3  不如  2 * 2
        if (n - timesOf3 * 3 == 1) {
            // 少分一个
            timesOf3 -= 1;
        }
        // 6 -> 3 *3 = 9
        // 2 * 2 * 2 = 8
        // 得到有多少个 2
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2) % MOD);
    }

    public static void main(String[] args) {
        _14_02_TestDemo a1402TestDemo = new _14_02_TestDemo();
        System.out.println(a1402TestDemo.cuttingRope(5));
    }
}
