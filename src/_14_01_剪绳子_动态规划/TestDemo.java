package _14_01_剪绳子_动态规划;

/**
 * @Description: 使用动态规划进行处理
 * @Author: matthew
 * @Date: 2023/1/8 15:08
 */
public class TestDemo {

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
        // 1 -> 1 = 0 ;
        // 2 -> 1 1 -> 1
        // 3 -> 1 2 -> 2
        // 4 -> 2 2 -> 4 | 3 -> 2 +  2 -> 1 | 1 1 1 1 -> 1
        int[] dic = new int[n+1];

        // 到 4 的 所有最优解,方便动态规划
        dic[1] = 1;
        dic[2] = 2;
        dic[3] = 3;
        dic[4] = 4;


        // 找到每层的最优解
        for (int i = 5; i <= n; i++) {
          int  max = 0;
            for (int j = 1; j <= i / 2; j++) {
                // dic[j] 左半段  5/2=2   1 ; 2
                // dic[i-j] 右半段  5-1 = 4 ; 5-2 = 3
                // 1 * 4 < 2 * 3
                int di = dic[j] * dic[i - j];
                if (max < di) { //如果此次循环的结果＞已知的 本层乘积 则进行替换
                    max = di;
                }
                dic[i] = max;
            }
        }
        return dic[n];
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.cuttingRope(5));
    }
}
