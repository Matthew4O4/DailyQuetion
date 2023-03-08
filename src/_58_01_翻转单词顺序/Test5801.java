package _58_01_翻转单词顺序;

/**
 * @Description: -
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * <p>
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * @Author: matthew
 */
public class Test5801 {

    /**
     * 反转语句
     * 采用倒循环,将单词放入新列表
     */

    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格

        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s, i + 1, j + 1).append(" "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim();// 转化为字符串并返回
    }


    public static void main(String[] args) {
        Test5801 test5801 = new Test5801();
        System.out.println(test5801.reverseWords("abc    def get "));
        System.out.println("abc def".length());
        System.out.println("abc def".lastIndexOf("f"));
    }

}
