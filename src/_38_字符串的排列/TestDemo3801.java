package _38_字符串的排列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo3801 {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            // 匹配到尾巴啦,收工
            res.add(String.valueOf(c));
            return;
        }

        // 匹配集 - 每层都有自己的 访问标记
        HashSet<Character> set = new HashSet<>();
        /**
         * 本层示意
         *
         * 1234
         * set[]
         * x=i=0
         * set[1]
         *
         * swap
         * c[x(0)] =1 = c[i(0)]
         * 1234
         * dfs();
         * swap
         * 1234
         *
         *
         * ----------
         *
         * set[1,2]
         * x=0,i=1
         *
         * swap
         * c[x(0)] = 1 -> c[x] =2
         * c[i(1)] = 2 -> c[i] =1
         *
         * dfs();
         * swap
         * 2134
         *
         * -----
         * set [1,2,3]
         * x = 0, i=2
         *
         * swap
         * 3214
         * dfs();
         * 1234
         *
         * -----
         *
         * set [1,2,3,4]
         * x = 0, i=2
         * swap
         * 4231
         * dfs();
         * 1234
         *
         *
         *
         *
         *
         *
         * 对最后两层来说              对最后三层来说
         * 从倒数第2位和倒数第1位换位 -> 倒数第2位和倒数第1位换位 and 倒数第3位和倒数第2位换位
         *                        -> 倒数第2位和倒数第1位换位....
         */
        for (int i = x; i < c.length; i++) {
            // 本层 如果 [某个数值与当前数值相同,换不换无意义]
            if (set.contains(c[i])) continue;
            // 本层 没访问过此数标记为访问过
            set.add(c[i]);
            // 交换 x 和 i 的位置
            char tmp = c[i];
            c[i] = c[x];
            c[x] = tmp;

            // 0 - x 位固定,玩后面的
            dfs(x + 1);

            // 玩完还原
            tmp = c[i];
            c[i] = c[x];
            c[x] = tmp;
        }
    }

    public static void main(String[] args) {
        TestDemo3801 testDemo3801 = new TestDemo3801();
        System.out.println(Arrays.toString(testDemo3801.permutation("12345")));
    }
}
