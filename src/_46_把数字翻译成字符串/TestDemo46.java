package _46_把数字翻译成字符串;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 *
 * 解答成功:
 * 	执行耗时:6 ms,击败了3.23% 的Java用户
 * 	内存消耗:39.2 MB,击败了5.11% 的Java用户
 * 	完犊子,看看大哥们怎么解得
 *
 * @Author: matthew
 */
public class TestDemo46 {
    int k;

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        k = 0;
        char[] chars = String.valueOf(num).toCharArray();
        myTranslateNum(chars, 0);
        return k;
    }

    private void myTranslateNum(char[] chars, int index) {
        if (index == chars.length) {
            k++;
            return;
        }

        myTranslateNum(chars,  index + 1);
        // 01 -> 不能认为 为 1; 所以 0开头的都要跳过2阶,只能走单阶
        if (chars[index] != '0' && index + 1 <= chars.length - 1) {
            int i = Integer.parseInt(chars[index] + "" + chars[index + 1]) + 97;
            // 如果他们两个之间的差值大于25则说明 超出了26个英文字母呢
            if (i <= 'z' && i >= 'a') {
                myTranslateNum(chars,  index + 2);
            }
        }
    }

    public static void main(String[] args) {
        TestDemo46 testDemo46 = new TestDemo46();
        System.out.println(testDemo46.translateNum(11));
        System.out.println(testDemo46.translateNum(26));
        System.out.println(testDemo46.translateNum(506));

//
//        System.out.println((int) '0');
//        System.out.println((int) 'a');
//
//        int a1 = 'a' - '0'; //49
//        int z1 = 'z' - '0'; //74
//        System.out.println((char) ('0' + 49));
//        System.out.println(a1);
//        System.out.println(z1);
    }
}
