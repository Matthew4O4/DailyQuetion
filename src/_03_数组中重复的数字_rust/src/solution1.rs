use std::ptr::null;

pub struct Solution {}

impl Solution {
    // 查找重复的数字
    pub fn find_repeat_number( nums: Vec<i32>) -> i32 {
        let mut numss = nums;
        // 超出边界的
        if numss.is_empty() {
            return -1;
        }
        // 不符合题意的
        for i in numss.iter() {
            if i < &0 || *i as usize > &numss.len()  - 1 {
                return -1;
            }
        }

        let mut i: usize = 0;
        while i < numss.len() {
            while numss[i] != i as i32 {
                if numss[i] == numss[numss[i] as usize] {
                    return numss[i];
                }
                let temp = numss[i];
                numss[i] = numss[temp as usize] ;
                numss[temp as usize] = temp;
            }
            i += 1;
        }
        return -1;
    }
}
