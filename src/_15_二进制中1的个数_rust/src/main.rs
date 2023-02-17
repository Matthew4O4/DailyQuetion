use crate::TestDemo01::number_of_1;
use crate::TestDemo02::number_of_2;

mod TestDemo01;
mod TestDemo02;

fn main() {
    // let a = 9;
    //
    // let b = 1;
    //
    // let mut c = a & b;
    //
    // println!("{}", a);
    // println!("{:08b}", a);
    // println!("{}", "aaaaaaa↑↑↑↑");
    // println!("{}", b);
    // println!("{:08b}", b);
    // println!("{}", "bbbbbbb↑↑↑↑");
    //
    // println!("{:08b}", c);
    // c = c >> b;
    // c = c & b;
    // println!("{:08b}", c);
    // println!("{}", c);
    let mut a = 8;
    for i in 1..8 {
        println!("{}",a);
        println!("{:08b}",a);
         a = a >> 1;
    }

    // println!("9的1有: ->{}", number_of_1(9));
    // println!("9的1有: ->{}", number_of_2(9));

}



