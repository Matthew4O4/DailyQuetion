package _47_礼物的最大价值;

/**
 * @Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 *
 * 该方法超时
 *
 * @Author: matthew
 */
public class TestDemo47 {

    /**
     * 只能 右移或者下移
     * 遍历每一条路线.
     * 如何剪枝?
     * *   [1,3,1],
     * *   [1,5,1],
     * *   [4,2,1]
     *
     * @param grid
     * @return
     */
    int y;
    int x;
    int res;

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        y = grid.length - 1;
        x = grid[0].length - 1;
        boolean dic[][] = new boolean[y + 1][x + 1];
        res = 0;
        myMaxValue(grid, dic, 0, 0, 0);
        return res;
    }

    public void myMaxValue(int[][] grid, boolean[][] dic, int curX, int curY, int k) {
//        if (x < curX || y < curY) return;
        // 上层已经计算完,本层进行相加
        if (x == curX && curY == y) this.res = Math.max(res, k + grid[y][x]);

        // 处理当前层 // 先右移
        if (!dic[curY][curX]) {
            k += grid[curY][curX];
            dic[curY][curX] = true;
            if (x > curX) {
                myMaxValue(grid, dic, curX + 1, curY, k);
            }
            if (y > curY) {
                myMaxValue(grid, dic, curX, curY + 1, k);
            }
            dic[curY][curX] = false;
        }
    }

    public static void main(String[] args) {
        TestDemo47 testDemo47 = new TestDemo47();
        System.out.println(testDemo47.maxValue(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(testDemo47.maxValue(new int[][]{{1}}));
    }

}
