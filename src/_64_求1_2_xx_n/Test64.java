package _64_求1_2_xx_n;

/**
 * @Description: -
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * @Author: matthew
 */
public class Test64 {
    public int sumNums(int n) {
        // 分割到0  并且加根
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;

         //大萨达多
    }

    public static void main(String[] args) {
        Test64 test64 = new Test64();
        System.out.println(test64.sumNums(3));
    }

}
