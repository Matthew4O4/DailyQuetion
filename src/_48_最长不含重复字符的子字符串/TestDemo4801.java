package _48_最长不含重复字符的子字符串;

import java.util.HashSet;

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
public class TestDemo4801 {


    /**
     * 最长不含 重复字符的 子段
     * 执行耗时:?? ms, 击败了3.78% 的Java用户
     * 内存消耗:?? MB,击败了25.89% 的Java用户
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        char[] chars = s.toCharArray();
        HashSet<Character> dic = new HashSet<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            // 记录最大值
            if (!dic.contains(chars[i])) {
                dic.add(chars[i]);
            } else {
                // 对比新的不同步谁更大
                max = Math.max(max, dic.size());
                // 获取重复的下一个坐标
            }
            // 当前和前面那个一样则继续新的
        }
        return Math.max(max, dic.size());
    }

    public static void main(String[] args) {
        TestDemo4801 testDemo48 = new TestDemo4801();
        System.out.println(testDemo48.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(testDemo48.lengthOfLongestSubstring("aba"));
        System.out.println(testDemo48.lengthOfLongestSubstring("aab"));
        System.out.println(testDemo48.lengthOfLongestSubstring("awwkaw"));
    }


}
