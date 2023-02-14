package _38_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 *
 *
 *
 * TIPS: 此种解题只能解决 目标集 没有重复元素的题. 故 不符合38题意
 * @Description:
 * @Author: matthew
 */
public class TestDemo38 {
    /**
     * 暴力解
     * a b c d e
     * a b c d e
     * a 的所有可能  1
     * a b 的所有可能 2
     * a b c 的所有可能 6
     * a b c d 的所有可能
     * <p>
     * 当 a 为第一个时, 后面又 b c d e 种变化
     * 当 a b 为前两个时, 后面有 c d e 种变化
     * 当 a b c 为前三个时, 后面有 d e 种变化
     * 当 a b c d 为前四个时, 后面有 e 种变化
     * <p>
     * 每个节点都可以作为第一个
     *
     *
     * 本方式要求 source[] 无重复数字,否则永远凑不满
     */


    ArrayList<String> list;

    public String[] permutation(String s) {
        // 返回集
        this.list = new ArrayList<>();
        // 处理
        permutation(new StringBuffer(), s.toCharArray());
        return list.toArray(new String[0]);
    }

    public void permutation(StringBuffer sb, char[] str) {
        // 如果长度触底,则添加进 结果集
        if (sb.length() >= str.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < str.length; i++) {
            // 排除已存在的,本方式要求 source[] 无重复数字,否则永远凑不满
            if (sb.lastIndexOf(String.valueOf(str[i])) != -1) continue;

            sb.append(str[i]);
            // 处理下一层
            permutation(sb, str);

            //取消选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        TestDemo38 testDemo38 = new TestDemo38();
        System.out.println(Arrays.toString(testDemo38.permutation("abad")));
    }
}
