package _16_数值的整数次方;

/**
 * @Description:
 * @Author: matthew
 */
public class TestDemo {
    // n =3
    // base =2
    double myPowS(double base, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return base;
        }

        double res = myPowS(base, n >> 1);
        res *= res;

        if (( n & 0x1) == 1) {
            res *= base;
        }

        return res;
    }

    double myPow(double base, long n) {
        if (n < 0) {
            return 1 / myPowS(base, -n);
        }
        return myPowS(base, n);
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
//        testDemo.myPow(null,null);
        System.out.println(testDemo.myPow(2, 4));
    }
}
