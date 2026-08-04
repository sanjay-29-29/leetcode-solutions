use std::collections::{HashSet};

impl Solution {
    pub fn find_missing_elements(nums: Vec<i32>) -> Vec<i32> {
        let set = nums.iter().collect::<HashSet<&i32>>();
        let min = nums.iter().min().unwrap();
        let max = nums.iter().max().unwrap();
        let mut res = Vec::new();

        for i in *min..=*max {
            if !set.contains(&i) {
                res.push(i);
            }
        }    

        return res;
    }
}
