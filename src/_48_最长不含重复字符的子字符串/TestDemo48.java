package _48_最长不含重复字符的子字符串;

import java.util.HashMap;

/**
 * @Description: -
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，
 * 计算该最长子字符串的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * <p>
 * s.length <= 40000
 * @Author: matthew
 */
public class TestDemo48 {


    /**
     * 最长不含 重复字符的 子段
     * pwawkew
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> dic = new HashMap<>();
        int max = 0;

        for (int i = 0; i < chars.length; i++) {
            // 记录最大值
            if (!dic.containsKey(chars[i])) {
                dic.put(chars[i], i);
            } else {
                // 对比新的不同步谁更大
                max = Math.max(max, dic.size());
                // 获取重复的下一个坐标
                i = dic.get(chars[i]);
                dic.clear();
            }
            // 当前和前面那个一样则继续新的
        }
        return Math.max(max, dic.size());
    }

    public static void main(String[] args) {
        TestDemo48 testDemo48 = new TestDemo48();
        System.out.println(testDemo48.lengthOfLongestSubstring("cabac"));
    }
}
