//package _12_矩阵中的路径;
//
///**
// * @Description:
// * @Author: matthew
// * @Date: 2023/1/7 21:09
// */
//public class _12_TestDemo {
//
//    int[][] ju = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//    int x;
//    int y;
//    // 高
//    int m;
//    // 宽
//    int n;
//    boolean[][] flagArray;
//    char[] wordArray;
//
//
//    public boolean exist(char[][] board, String word) {
//        m = board.length; // 很明显 int [A] [B]    A 是行,也就是Y轴   B是列,也就是X轴
//        n = board[0].length;
//        flagArray = new boolean[m][n];
//        wordArray = word.toCharArray();
//        for (int i = 0; i < m; i++) {
//            for (int l = 0; l < n; l++) {
//                // y 轴
//                y = i;
//                // x 轴
//                x = l;
//                if (foundBody(board, 0)) return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 不可以出现在数组中
//     * bodyArray 的上下左右   boolean[][] dic={-1,0},{0,1},{1,0},{0,-1}
//     *
//     * @return
//     */
//    public boolean foundBody(char[][] board, int index) {
//
//        // 如果当前不对付,则返回false
//        if ( (y < 0 || y >= m || x < 0 || x >= n )
//                || flagArray[y][x]
//                || board[y][x] != wordArray[index]) {
//            return false;
//        }
//        // 如果到底 则返回true
//        if (index == wordArray.length - 1) {
//            return true;
//        }
//
//        // 设置当前节点为成功匹配
//        flagArray[y][x] = true;
//        // 继续匹配后面的节点
//        for (int[] ints : ju) {
//            //上下左右瞧 中了就递进下
//            x += ints[0];
//            y += ints[1];
//            if (foundBody(board, index + 1)) {
//                return true;
//            } else {
//                x -= ints[0];
//                y -= ints[1];
//            }
//        }
//        flagArray[y][x] = false;
//        return false;
//    }
//
//    public static void main(String[] args) {
//        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        _12_TestDemo testDemo = new _12_TestDemo();
//        System.out.println(testDemo.exist(chars, "ABCB")); //f
//        System.out.println(testDemo.exist(chars, "ABCC"));//t
//        System.out.println(testDemo.exist(chars, "ABCEA"));//f
//    }
//}
