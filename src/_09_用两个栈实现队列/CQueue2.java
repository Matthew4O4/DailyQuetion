package _09_用两个栈实现队列;

import java.util.Stack;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/5 10:26
 */
public class CQueue2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue2() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        // 出队列的时候才开始 迁移元素.  防止每次添加元素都要迁移
        if (stack2.empty()) {
            while (!stack1.empty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }

        if (!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }
}
