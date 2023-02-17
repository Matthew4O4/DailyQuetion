package _13_机器人的运动范围;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/7 23:34
 */
public class _01_TestDemo {
    // 记录已经走过的
    boolean[][] dic;
    // 记录宽度
    int xX;
    //记录高度
    int yY;

    /**
     * @param k 坐标 合上限
     * @param x 宽度
     * @param y 高度
     * @return 可达块个数
     */
    public int movingCount(int k, int x, int y) {
        // 边界条件
        if (k < 0 || x <= 0 || y <= 0) {
            return 0;
        }
        // 记录 宽高
        xX = x;
        yY = y;
        // 初始化 词典
        dic = new boolean[y][x];
        // 递归开始
        return movingCountCore(k, 0, 0);
    }

    /**
     * 判断可达数量
     * @param k
     * @param x
     * @param y
     * @return
     */
    private int movingCountCore(int k, int x, int y) {
        int count = 0;
        if (check(k, x, y)) {
            dic[y][x] = true;
            count = 1 // 当前格算 1
                    + movingCountCore(k, x, y + 1) //上
                    + movingCountCore(k, x, y - 1) //下
                    + movingCountCore(k, x - 1, y) //左
                    + movingCountCore(k, x + 1, y); //右
        }
        return count;
    }

    private boolean check(int k, int x, int y) {
        if (x >= 0 && xX > x && y >= 0 && yY > y
                && (getDigitSum(x) + getDigitSum(y)) <= k
                && !dic[y][x]) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            //拿个位数
            sum += x % 10;
            //去掉一位
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        _01_TestDemo testDemo = new _01_TestDemo();
        System.out.println(testDemo.movingCount(1, 2, 3));
        System.out.println(testDemo.movingCount(0, 3, 1));
    }
}
