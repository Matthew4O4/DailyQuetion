package _30_包含min函数的栈;

import java.util.Stack;

/**
 * @Description:
 * @Author: matthew
 */
class MinStack {
    Stack<Integer> auxiliaryStack;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     * as: 1 2 -3  4  5  6
     * bs: 1 1 -3 -3 -3 -3
     */
    public MinStack() {
        this.stack = new Stack<>();
        this.auxiliaryStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (auxiliaryStack.empty()) {
            auxiliaryStack.push(x);
        } else {
            auxiliaryStack.push(Math.min(auxiliaryStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        auxiliaryStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return auxiliaryStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
    }
}