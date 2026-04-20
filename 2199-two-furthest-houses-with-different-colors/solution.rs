use std::cmp::{max};

impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        let mut res = 0;

        for (i, val1) in colors.iter().enumerate() {
            for (j, val2) in colors.iter().enumerate() {
                if val1 != val2 {
                    res = max(
                        res,
                        (j - i) as i32
                    );
                }
            }
        }

        res
    }
}
