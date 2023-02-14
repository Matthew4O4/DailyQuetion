package _43_一到n整数中1的出现次数X;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo4301 {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        char strN[] = new char[50];
        return NumberOf1(strN, 0);
    }

    private int NumberOf1(char[] strN, int index) {
        return 2;
    }
}
