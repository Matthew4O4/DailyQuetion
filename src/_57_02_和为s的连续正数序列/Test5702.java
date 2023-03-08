package _57_02_和为s的连续正数序列;

import java.util.*;

/**
 * @Description: -
 * -输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * -
 * -序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * -
 * -示例 1：
 * -
 * -输入：target = 9
 * -输出：[[2,3,4],[4,5]]
 * -示例 2：
 * -
 * -输入：target = 15
 * -输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * @Author: matthew
 */
public class Test5702 {

    /**
     * 连续的 能够组成此数的...
     * 1 -> 1
     * 2 -> 2
     * 3 -> 1 2
     * 4 -> 4
     * 5 -> 2 3
     * 6 -> 1 2 3
     * 7 -> 7
     * 8 -> 8
     * 9 -> 2 3 4,4 5
     * 10-> 1 2 3 4
     *
     * @param target
     * @return
     */
    /**
     * 一组数 往后移动,如果小于则加后面,如果大于则减前面
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        Deque<Integer> temp = new LinkedList<>();
        ArrayList<int[]> res = new ArrayList<>();
        int sum = 1;
        temp.add(i);
        int flag = (target+1) /2 ;
        while (i <= flag) {
            // 说明仍然小于目标
            if (sum < target) {
                i++;
                sum += i;
                temp.addLast(i);
                // 说明大于目标
            } else if (sum > target) {
                sum -= temp.pop();
            } else {
                int[] te = new int[temp.size()];
                Iterator<Integer> iterator = temp.iterator();
                for (int j = 0; iterator.hasNext(); j++) {
                    Integer next = iterator.next();
                    te[j] = next;
                }

                res.add(te);
                sum -= temp.pop();
                i++;
                sum += i;
                temp.addLast(i);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Test5702 test5702 = new Test5702();
        System.out.println(Arrays.deepToString(test5702.findContinuousSequence(99)));
    }
}
