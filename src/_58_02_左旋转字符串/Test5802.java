package _58_02_左旋转字符串;

/**
 * @Description:
 * @Author: matthew
 */
public class Test5802 {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     * <p>
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     * <p>
     * <p>
     * 解题思路双指针
     * 将将将将将将将将将将将
     * 50效率
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int index = n; index < chars.length; index++) {
            sb.append(chars[index]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * Runtime:0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage:41.4 MB, less than 55.97% of Java online submissions.
     */
    public String reverseLeftWords2(String s, int n) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s, n, s.length()).append(s, 0, n);
        return sb.toString();
    }

    public static void main(String[] args) {
        Test5802 test5802 = new Test5802();
        System.out.println(test5802.reverseLeftWords2("abcd", 4));
    }
}
