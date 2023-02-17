package _05_替换空格;

/**
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * @Author: matthew
 * @Date: 2023/1/2 18:04
 */
public class TestDemo {
    static String replaceSpace(String str) {
        if (str == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
