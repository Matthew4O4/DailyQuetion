package _09_用两个栈实现队列;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/5 09:39
 */
public class TestDemo {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);

    }
}
