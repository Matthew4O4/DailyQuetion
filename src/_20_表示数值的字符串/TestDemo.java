package _20_表示数值的字符串;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {


    int index;
    char[] target;

    // 四部分 整数
    // 小数
    // E 指数
    // 整数
    boolean isNumber(String s) {
        if (s == null || "".equals(s)) return false;
        index = 0;
        this.target = s.toCharArray();
        while (index < target.length && target[index] == ' ') {
            index++;
        }
        //第一位纯数字的下一个下标,
        boolean flag = canHaveSignNumber();

        //.: 小数点前后都可以没东西,但不能同时没东西
        if (index < target.length && target[index] == '.') {
            index++;
            flag = haveNumber() || flag;
        }

        //e|E: 前面必须有数字,并且后面必须有整数
        if (index < target.length
                && (target[index] == 'E'
                || target[index] == 'e')) {
            index++;
            flag = flag && canHaveSignNumber();
        }
        while (index < target.length && target[index] == ' ') {
            index++;
        }
        return flag && index == target.length;
    }


    boolean haveNumber() {
        int flag = index;
        while (index < target.length && target[index] >= '0' && target[index] <= '9') {
            index++;
        }
        return (index > flag);
    }

    boolean canHaveSignNumber() {
        if (index < target.length && (target[index] == '+' || target[index] == '-'))
            index++;
        return haveNumber();
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
//        System.out.println(testDemo.isNumber("222.22E"));
//        System.out.println(testDemo.isNumber("12e"));
//        System.out.println(testDemo.isNumber("1a3.14"));
//        System.out.println(testDemo.isNumber("+5"));
//        System.out.println(testDemo.isNumber("12E+5.4"));
//        System.out.println(testDemo.isNumber("12E+5"));
//        System.out.println(testDemo.isNumber("0"));
//        System.out.println(testDemo.isNumber("  0"));
//        System.out.println(testDemo.isNumber("1.1 "));
        System.out.println(testDemo.isNumber(" "));
    }


}