package _09_用两个栈实现队列;

import java.util.Stack;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/5 09:31
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     *
     */
    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * [1,2,3,4,5]
     * [5,4,3,2,1]
     * 每次先入栈A,然后整体换栈B
     * ** 其实在插入的时候进行 捯饬 是不好的时机,而是导出的时候进行捯饬.
     * - 只有栈2为空时才尝试把栈1的数据放入栈2
     */
    public void appendTail(int value) {

        while (!stack2.empty()){
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        stack1.push(value);
        while (!stack1.empty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }

    }

    public int deleteHead() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }

}
