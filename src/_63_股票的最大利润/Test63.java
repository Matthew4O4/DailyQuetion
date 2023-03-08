package _63_股票的最大利润;

/**
 * @Description: -
 * <p>
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Author: matthew
 * <p>
 * 好家伙不是这么做
 */
public class Test63 {


    public int maxProfit(int prices[]) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                // 记录最小利润
                min = prices[i];
                // 替换更大利润
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test63 test63 = new Test63();
        System.out.println(test63.maxProfit(new int[]{3, 2, 1}));
        System.out.println(test63.maxProfit(new int[]{1,2,3}));
    }


}
