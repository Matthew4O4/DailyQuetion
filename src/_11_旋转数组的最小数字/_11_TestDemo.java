package _11_旋转数组的最小数字;

/**
 * @Description: 二分法
 * <p>
 * 两个指针
 * [1,2,3,4,5]
 * <p>
 * [4,5,1,2,3]
 * 如何找到最小的数字?
 * 先找到从哪里开始旋转即可
 * 两个指针
 * 最左边为 A
 * 最右边为 B
 * [4(A),5,1(i),2,3(B)]
 * 每次找到中间数 i
 * - 如果 i > B, 则表示旋转的起点不在此处,而在右边
 * -- 指针A位移到中间数+1
 * <p>
 * - 如果中 i <= B,则表示旋转的起点在此处 或者 在左边
 * -- 指针 B 位移到中间数
 * [4(A),5(i),1(B)]
 * 再次循环找 中间新 i
 * <p>
 * -  [1(ABi)]
 * @Author: matthew
 * @Date: 2023/1/6 10:42
 */
public class _11_TestDemo {


    // 最小数字
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }

        int indexA = 0;
        int indexB = numbers.length - 1;

        while (indexB > indexA) {
            int mind = (indexB + indexA) / 2;
            if (numbers[mind] > numbers[indexB]) {
                indexA = mind + 1;
            } else if (numbers[mind] < numbers[indexB]) {
                indexB = mind;
            } else {
                indexB -= 1;
            }
        }
        return numbers[indexB];
    }

    public static void main(String[] args) {
//        System.out.println((5 + 6)/ 2);
        _11_TestDemo testDemo = new _11_TestDemo();
        System.out.println(testDemo.minArray(new int[]{4, 7, 7, 7, 7, 1, 2, 3, 4}));
        System.out.println(testDemo.minArray(new int[]{3, 3, 1, 3}));
        System.out.println(testDemo.minArray(new int[]{3, 1, 1}));
    }
}
