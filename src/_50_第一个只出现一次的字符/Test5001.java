package _50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: matthew
 */
public class Test5001 {
    /**
     * 执行耗时:18 ms,击败了65.78% 的Java用户
     * 内存消耗:42 MB,击败了46.89% 的Java用户
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {

        if (s == null) {
            return ' ';
        }
        if (s.length() == 1) {
            return s.toCharArray()[0];
        }
        LinkedHashMap<Character, Boolean> dic = new LinkedHashMap<>();

        // 第一个只出现一次的字符
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (dic.containsKey(aChar)) {
                dic.put(aChar, Boolean.FALSE);
                continue;
            }

            if (!dic.containsKey(aChar)) {
                dic.put(aChar, Boolean.TRUE);
            }
        }

        for (Map.Entry<Character, Boolean> characterBooleanEntry : dic.entrySet()) {
            if (characterBooleanEntry.getValue()) {
                return characterBooleanEntry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Test5001 test50 = new Test5001();
//        System.out.println(test50.firstUniqChar("abcabczzbbxx"));
        System.out.println(test50.firstUniqChar("leetcode"));
//        System.out.println(test50.firstUniqChar("a"));

        System.out.println((int) 'a');
    }
}
