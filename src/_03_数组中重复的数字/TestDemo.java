package _03_数组中重复的数字;

/**
 * @Description: 找出数组中重复的数字
 * 在一个长度为n的数组里所有的数字都在 0~n-1的范围内,数组中某些数字是重复的,
 * * 但是不知道第几个重复了,也不知道每个数字重复了几次
 * * 请找出数组中任意重复数字.
 * * 例如: 如果输入长度为7的数组 {2,3,1,0,2,5,3},那么对应的答案就是 2 / 3
 * @Author: matthew
 * @Date: 2022/12/30 22:40
 */
public class TestDemo {

    static int duplicate(int numbers[]) {
//超出边界的
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
//不符合题意的: 超出了 0~n-1
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            // {2,3,1,0,2,5,3}
            // {1,3,2,0,2,5,3}
            // {3,1,2,0,2,5,3}
            // {0,1,2,3,2,5,3}
            // {0,1,2,3,2,5,3}
            while (numbers[i] != i) {// 当数组中当前元素 != 下标时,说明当前元素未归位
                if (numbers[i] == numbers[numbers[i]]) {// 也就是 当前元素 和 已经归位的元素撞了
                    return numbers[i];
                }
                // 没撞则更换当前下标的值,为 当前下标值的 下标数
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] one = {1, 2, 3, 5, 4, 5, 5};
        int[] two = {1, 2, 3, 4, 5, 6};
        int[] three = {1, 22};
        System.out.println(duplicate(one));
        System.out.println(duplicate(two));
        System.out.println(duplicate(three));
    }

}
