/// 此方案负数时:会造成无限循环
pub fn number_of_2(n: i32) -> i32 {
    let mut copy_n = n;
    //统计用
    let mut count = 0;

    while copy_n != 0 {
        count = 1 + count;
        // & 全为1则为1
        // | 有1个为1则为1
        // ^ 只有1个为1时才为1

        // 10101010
        // 10101001
        // ↓↓↓↓↓↓↓↓
        // 10101001
        // 10101000

        // 本身 -1 相当于从右边数 第一个1及到最右侧的全部反转
        // 然后再与原数 & 会直接拿到 最后一位1及之后变为0的结果
        copy_n = (copy_n - 1) & copy_n;
    }

    return count;
}