use crate::solution1::Solution;

mod solution1;

fn main() {
    let a = vec![1, 2, 3, 5, 4, 5, 5];
    println!("{}",Solution::find_repeat_number(a).to_string());
}
