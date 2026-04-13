use std::cmp::{min};

impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        let mut res = i32::MAX;

        for i in 0..nums.len() {
            if nums[i] == target {
                res = min(res, start.abs_diff(i as i32) as i32);
            }
        }

        res
    }
}
