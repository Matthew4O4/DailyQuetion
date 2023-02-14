package _43_一到n整数中1的出现次数X;

/**
 * @Description: 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有
 * 1、10、11和12，    1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * @Author: matthew
 */
public class TestDemo43 {
    public int countDigitOne(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            int item = i;
            while (item > 0) {
                // 如果当前 层等1 计数
                if (item % 10 == 1) k++;
                item /= 10;
            }
        }
        return k;
    }

    /**
     * 每个位都有可能出现一次
     * 1
     * 10 12 13 14 15 16 17 18 19
     * 01
     * 11
     * 21
     * 31
     * 41
     * 51
     * 61
     * 71
     * 81
     * 91
     * <p>
     * 111
     *
     * @param args
     */

    public static void main(String[] args) {
        TestDemo43 testDemo43 = new TestDemo43();

        System.out.println("5   :" +testDemo43.countDigitOne(5   ));
        System.out.println("10  :" +testDemo43.countDigitOne(10  ));
        System.out.println("11  :" +testDemo43.countDigitOne(11  ));
        System.out.println("20  :" +testDemo43.countDigitOne(20  ));
        System.out.println("30  :" +testDemo43.countDigitOne(30  ));
        System.out.println("40  :" +testDemo43.countDigitOne(40  ));

        System.out.println("100 :" +testDemo43.countDigitOne(100 ));
        System.out.println("200 :" +testDemo43.countDigitOne(200 ));
        System.out.println("240 :" +testDemo43.countDigitOne(240 ));
        System.out.println("299 :" +testDemo43.countDigitOne(299 ));
        System.out.println("300 :" +testDemo43.countDigitOne(300 ));
        System.out.println("340 :" +testDemo43.countDigitOne(340 ));
        System.out.println("400 :" +testDemo43.countDigitOne(400 ));
        System.out.println("1000:" +testDemo43.countDigitOne(1000));
        System.out.println("1340:" +testDemo43.countDigitOne(1340));
        System.out.println("2000:" +testDemo43.countDigitOne(2000));
        System.out.println("3000:" +testDemo43.countDigitOne(3000));
        System.out.println("10000:" +testDemo43.countDigitOne(10000));
        System.out.println("==============");

        // 如果是个位数只能有一个
        // 如果是十位数: 且个位数>1
        // 十位不是1

        int a = 123;

        System.out.println(a);
        System.out.println(a % 10);
        System.out.println(a / 10 % 10);
        System.out.println(a / 10 / 10 % 10);
    }
}
