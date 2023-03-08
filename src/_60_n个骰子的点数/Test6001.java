package _60_n个骰子的点数;

import java.util.Arrays;

/**
 * @Description: -
 * -把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * -
 * -你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * -
 * -示例 1:
 * -
 * -输入: 1
 * -输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * -示例 2:
 * -
 * -输入: 2
 * -输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * -@Author: matthew
 */
public class Test6001 {

    /**
     * 鉴于自己写的超时了,我们决定看看他们怎么做
     *
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        Test6001 test60 = new Test6001();
        System.out.println(Arrays.toString(test60.dicesProbability(2)));
        //	Your input:2
        //	Output:[0.09091,0.09091,0.18182,0.18182,0.27273,0.27273,0.36364,0.36364,0.45455,0.45455,0.54545]
        //Expected:[0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
    }
}
