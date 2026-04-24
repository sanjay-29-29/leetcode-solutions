use std::cmp::{max};

impl Solution {
    pub fn furthest_distance_from_origin(moves: String) -> i32 {
        let mut left: i32 = 0;
        let mut mid: i32 = 0;
        let mut right: i32 = 0;

        for i in moves.as_bytes()  {
            if *i == b'L' {
                left += 1;
            }
            else if *i == b'R' {
                right += 1;
            }
            else {
                mid += 1;
            }
        }

        return left.abs_diff(right) as i32 + mid;
    }
}
