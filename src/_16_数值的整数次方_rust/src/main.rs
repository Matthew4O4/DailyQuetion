fn main() {
    println!("{}", my_pow(1.0, -2147483648));
    // n: 3->1
}

pub fn my_pows(x: f64, n: i64) -> f64 {
    if n == 0 {
        return 1 as f64;
    }
    if n == 1 {
        return x;
    }
    // 递归每层 1/2
    let mut result = my_pows(x, n >> 1);
    result *= result;
    // 一个整数与0x1做按位与运算得到的结果是0或者1就可以判断出这个整数是偶数还是奇数。
    if (n & (0x1 as i64)) == 1 {
        result *= x;
    }
    return result;
}

pub fn my_pow(x: f64, n: i64) -> f64 {
    if n < 0 {
        if x == 1.0 {
            return 1.0 / -n;
        }
        return 1.0 / my_pows(x, -n);
    }
    return my_pows(x, n);
}


//  2^8     =    2^2 * 2^2 * 2^4