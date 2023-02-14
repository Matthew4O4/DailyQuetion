package _47_礼物的最大价值;

/**
 * @Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
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
 * @Author: matthew
 */
public class TestDemo4701 {

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

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int y = grid.length;
        int x = grid[0].length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == j && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[y - 1][x - 1];
    }


    public static void main(String[] args) {
        TestDemo4701 testDemo47 = new TestDemo4701();
        System.out.println(testDemo47.maxValue(new int[][]{
                {1, 3, 1, 7},
                {1, 5, 1, 1},
                {22,2, 1, 3}}));
        System.out.println(testDemo47.maxValue(new int[][]{{1}}));
    }

}
