package _60_n个骰子的点数;

import java.util.*;

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
public class Test60 {

    /**
     * 说到底就是排列组合
     * 不同结果出现的合的次数的问题
     * 首先完成各种组合,组合简之又简,123456 可重复使用.
     * 使用Map去记录出现的次数,或者数组都可以
     *
     *
     *
     *
     * @param n
     * @return
     *
     * 超时了!!!!嚓
     *
     */

    public double[] dicesProbability(int n) {

        if (n <= 0) {
            return new double[0];
        }
        // 点数
        LinkedHashMap<Integer, Integer> resMap = new LinkedHashMap<>();
        dp(n, resMap, 0, 0);
        int size = resMap.size();
        double[] res = new double[size];
        double sum = 0;
        for (Integer v : resMap.keySet()) {
            sum += resMap.get(v);
        }

        ArrayList<Map.Entry<Integer, Integer>> doubles = new ArrayList<>(resMap.entrySet());
        doubles.sort(Comparator.comparingInt(Map.Entry::getKey));

        int i = 0;
        for (Map.Entry<Integer, Integer> v : doubles) {
            res[i++] = (double) v.getValue() / sum;
        }

        return res;
    }

    public void dp(int n, HashMap<Integer, Integer> resMap, int currentIndex, int sum) {
        // 终止条件
        if (currentIndex == n) {
            if (resMap.containsKey(sum)) {
                resMap.put(sum, (resMap.get(sum) + 1));
            } else {
                resMap.put(sum, 1);
            }
            return;
        }

        // 层级尝试
        for (int i = 1; i <= 6; i++) {
            dp(n, resMap, currentIndex + 1, sum + i);
        }
    }

    public static void main(String[] args) {
        Test60 test60 = new Test60();
        System.out.println(Arrays.toString(test60.dicesProbability(2)));
        //	Your input:2
        //	Output:[0.09091,0.09091,0.18182,0.18182,0.27273,0.27273,0.36364,0.36364,0.45455,0.45455,0.54545]
        //Expected:[0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
    }
}
