package _19_正则表达式匹配;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {

    Map<String, Boolean> dicMap;

    // s 目标串
    // p 模式串

    boolean dp(String s, String p) {

        if ((s == null || p == null)&& p != s) {
            return false;
        }if (s==p){
            return true;
        }

        dicMap = new HashMap<>();
        return mdp(s.toCharArray(), 0, p.toCharArray(), 0);
    }


    boolean mdp(char[] s, int i, char[] p, int j) {
        int m = s.length, n = p.length;
        // base case :  如果j到头了,i也到头了则说明匹配成功了
        if (j == n) {
            return m == i;
        }
        // base case : 如果i到头了,j没到头,j必须全部是  x*的格式才行哦~
        // abc  abc*
        if (i == m) {
            // 如果n剩余的长度是个偶数才有戏 y*\ x*\ ....     abc-abc* 这种在下面匹配
            if (((n - j) & 1) == 1) {
                return false;
            }
            // 检查一下是否为   * x* y*   abc*x*y*  ->
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }
        // 记录状态(i,j)
        String key = i + "," + j;
        if (dicMap.containsKey(key)) return dicMap.get(key);

        boolean res;
        // 当前针 匹配上了
        if (s[i] == p[j] || p[j] == '.') {
            // 如果j还没到头,并且j的下一个 '*' 则尝试一下
            // 1. j的再下一个字符是否符合
            // 2. 如果不符合则 往后推 i 继续匹配
            // 满足以上其一则继续
            if (j < n - 1 && p[j + 1] == '*') {
                res = mdp(s, i, p, j + 2) //
                        || mdp(s, i + 1, p, j);
            } else {
                res = mdp(s, i + 1, p, j + 1);
            }
        } else {
            // 如果没匹配上,则看看此值后面是否为 * 可省略
            if (j < n - 1 && p[j + 1] == '*') {
                res = mdp(s, i, p, j + 2);
            } else res = false;
        }
        // 将结果放入
        dicMap.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.dp(null, null));
    }
}
