/// 此方案负数时:会造成无限循环
pub fn number_of_1(n: i32) -> i32 {
    let mut copy_n = n;
    //统计用
    let mut count = 0;

    while copy_n != 0 {

        // 判断除掉最后一个1后是否为0 了. 如果不是则说明还有1
        if copy_n & 1 != 0 { count = 1 + count; }

        // 向右位移1
        copy_n = copy_n >> 1;

        println!("{}", copy_n);
        println!("{:08}", copy_n)
    }

    return count;
}