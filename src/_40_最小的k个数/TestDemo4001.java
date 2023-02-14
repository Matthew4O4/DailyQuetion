package _40_最小的k个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo4001 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        /**
         * 使用大根堆排序
         * 大的在上面
         *
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {

            // compare 返回结果集为正的在上
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        queue.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            if (queue.size() == k) {
                // 上面是最大的,如果新的数 < 最顶 ,则出栈最顶 压入新数
                if (queue.peek() > item) {
                    queue.poll();
                    queue.add(item);
                }
            } else {
                queue.add(item);
            }
        }

        Iterator<Integer> iterator = queue.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        TestDemo4001 testDemo4001 = new TestDemo4001();
        System.out.println(Arrays.toString(testDemo4001.getLeastNumbers(new int[]{1, 2, 4, 5, 3}, 4)));
    }
}
