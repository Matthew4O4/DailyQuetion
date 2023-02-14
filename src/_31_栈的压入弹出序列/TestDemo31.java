package _31_栈的压入弹出序列;

import java.util.Stack;

/**
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * @Author: matthew
 * <p>
 * 12345
 * <p>
 * 54321
 * 45321
 * 15432
 * 21345
 * 43512 x : 1> 2> 3> 4> 4< 3< 5> 5< 2< 1<  :43521 :  最大下标 之后的 下标只能是递减的
 * 12345
 * 12543
 * 21354
 * : 栈中所有的数只能小于 刚出栈的数
 * :
 * 42315 x
 * <p>
 * 1> 1< 2> 2< 3> 3< 4> 4< 5> 5<    :12345
 * 1> 2> 2< 1< 3> 3< 4> 4< 5> 5<    :21345
 * 1> 2> 3> 3< 2< 1< 4> 4< 5> 5<    :32145
 * 1> 2> 3> 3< 2< 1< 4> 5> 5< 4<    :32154
 * 1> 2> 3> 4> 5> 5< 4< 3< 2< 1<    :54321
 * 1> 2> 2< 1< 3> 3< 4> 5> 5< 4<    :21354
 */
public class TestDemo31 {

    Stack<Integer> stack = new Stack<>();

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }


        for (int k = 0, i = 0; k < popped.length && i < popped.length;k++ ) {
            //一直压栈
            stack.push(pushed[k]);
            //遇到一样的就出栈,出道不一样为止
            while ((!stack.isEmpty()) && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        TestDemo31 t = new TestDemo31();
        System.out.println(t.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 1, 2, 3,4}));
    }
}
