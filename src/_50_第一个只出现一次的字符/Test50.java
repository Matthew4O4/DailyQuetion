package _50_第一个只出现一次的字符;

/**
 * @Description:
 * @Author: matthew
 */
public class Test50 {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例 1:
     * <p>
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     * <p>
     * 输入：s = ""
     * 输出：' '
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s==null ){
            return ' ';
        }
        if (s.length()==1){
            return s.toCharArray()[0];
        }
        // 第一个只出现一次的字符
        char[] chars = s.toCharArray();
        int loop = 0;
        boolean[] dic = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (dic[i]) continue;
            int j = i + 1;
            for (; j < chars.length; j++) {
                if (dic[j]) continue;
                if (chars[i] == chars[j]) {
                    dic[j] = true;
                    dic[i] = true;
                }
            }
            if (!dic[i]) {
                return chars[i];
            }
        }
        return ' ';
    }
    public static void main(String[] args) {
        Test50 test50 = new Test50();
        System.out.println(test50.firstUniqChar("leetcode"));
        System.out.println(test50.firstUniqChar("a"));
    }
}
