//package _46_把数字翻译成字符串;
//
///**
// * @Description: 解答成功:
// * 执行耗时:6 ms,击败了3.23% 的Java用户
// * 内存消耗:39.2 MB,击败了5.11% 的Java用户
// * 完犊子,看看大哥们怎么解得
// * @Author: matthew
// */
//public class TestDemo4601 {
//    int k;
//    int length;
//
//    public int translateNum(int num) {
//        if (num < 10) {
//            return 1;
//        }
//        k = 0;
//        length = String.valueOf(num).length();
//
//        myTranslateNum(num, 0);
//        return k;
//    }
//
//    private void myTranslateNum(int num, int index) {
//        k++;
//        if ( ) {
//            return;
//        }
//
//        if (index != 0) {
//            num = num % (10 * index);
//        }
//
//        myTranslateNum(num, index + 1);
//        if (index + 1 <= length - 1) {
//            //1111 117
//            int i = num % 100;
//            // 如果他们两个之间的差值大于25则说明 超出了26个英文字母呢
//            if (i >= 10 && i <= 25) {
//                myTranslateNum(num, index + 2);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(100 % 1);
//    }
//
//}
