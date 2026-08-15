use std::collections::{HashMap};

impl Solution {
    pub fn longest_subsequence(nums: Vec<i32>) -> i32 {
        let mut res: i32 = 0;
        let mut xor = 0;
        let mut is_zero = true;

        for i in &nums {
            // map.entry(i).and_modify(|val| *val += 1).or_insert(1);
            xor ^= *i;
            
            if *i > 0 {
                is_zero = false;
            }
        }        

        if is_zero {
            return 0;
        }
        // println!("{} {}",sum, (n * (n + 1)) / 2);

        if xor == 0 {
            return nums.len() as i32 - 1;
        }

        return nums.len() as i32;
    }
}
