fn main() {
    let a: Vec<Vec<i32>> = vec![
        vec![1, 4, 7, 11, 15],
        vec![2, 5, 8, 12, 19],
        vec![3, 6, 9, 16, 22],
        vec![10, 13, 14, 17, 24],
        vec![18, 21, 23, 26, 30],
    ];
    let a: Vec<Vec<i32>> = vec![
        vec![-5]
    ];

    println!("{}", Solution::find_number_in2_d_array(a, -10));
}

pub struct Solution {}

impl Solution {
    // 二维数组中查找原素
    pub fn find_number_in2_d_array(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let  copy_matrix = matrix;
        if copy_matrix.is_empty() || copy_matrix[0].is_empty() {
            return false;
        }

        let rows = copy_matrix.len();
        let mut row = 0;
        let mut column = copy_matrix[0].len() - 1;

        while row < rows && column >= 0 {
            if copy_matrix[row][column] == target {
                return true;
            } else if copy_matrix[row][column] > target {
                if column == 0 {
                    return false;
                }
                column = column - 1;
            } else {
                row = row + 1;
            }
        }
        return false;
    }
}