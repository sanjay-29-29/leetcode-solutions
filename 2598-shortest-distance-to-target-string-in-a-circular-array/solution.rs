use std::cmp::{min};

impl Solution {
    pub fn closest_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        let mut res = i32::MAX;
        let mut i = 0;

        while i < words.len() {
            if words[(i + start_index as usize) % words.len()] == target {
                res = min(res, i as i32);
            }
            i += 1;
        }

        i = 0;
        let mut dummy_val: i32 = start_index;

        while i < words.len() {
            if dummy_val == -1 {
                dummy_val = (words.len() - 1) as i32;
            }

            if words[dummy_val as usize] == target {
                res = min(res, i as i32) as i32;
            }

            dummy_val -= 1;

            i += 1;
        }

        if res == i32::MAX {
            return -1
        }

        return res;
    }
}
