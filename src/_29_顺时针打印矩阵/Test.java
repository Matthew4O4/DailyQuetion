package _29_顺时针打印矩阵;

import java.util.Arrays;

/**
 * @Description:
 * @Author: matthew
 */
public class Test {


    /**
     * 123
     * 456
     * 789
     * <p>
     * 123698745
     * 按照 向下 -> 向左 -> 向上 -> 向右 打印
     *
     * @param matrix
     * @return
     */

    int[][] movieDic = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] dicFlag = new boolean[m][n];
        int allIndex = m * n;
        int[] res = new int[allIndex];

        int index = 0;
        int x = 0;
        int y = 0;

        dicFlag[y][x] = true;
        res[index] = matrix[y][x];
        index++;

        //旋转方向
        while (index != allIndex) {
            for (int[] ints : movieDic) {
                while ((index != allIndex)) {
                    y += ints[0];
                    x += ints[1];
                    if (x < 0 || y < 0 || x >= n || y >= m || dicFlag[y][x]) {
                        y -= ints[0];
                        x -= ints[1];
                        break;
                    }
                    dicFlag[y][x] = true;
                    res[index] = matrix[y][x];
                    index++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(Arrays.toString(test.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13,14,15,16}})));
        System.out.println(Arrays.toString(test.spiralOrder(new int[][]{{1, 2, 3, 4}})));
        System.out.println(Arrays.toString(test.spiralOrder(new int[][]{{1}})));
    }


}
