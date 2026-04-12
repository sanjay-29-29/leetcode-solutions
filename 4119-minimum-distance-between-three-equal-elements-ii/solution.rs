use std::cmp::{min, max};
use std::collections::HashMap;

impl Solution {
    pub fn minimum_distance(nums: Vec<i32>) -> i32 {
        let mut res = -1;
        let mut map : HashMap<i32, Vec<i32>> = HashMap::new();

        for i in 0..nums.len() { 
            match map.get_mut(&nums[i]) {
                Some(arr) => arr.push(i as i32),
                _ => {
                    let mut arr = Vec::new();
                    arr.push(i as i32);
                    map.insert(nums[i], arr);
                }
            }
        }        

        for (key, val) in map.iter() {
            if val.len() >= 3 {
                // let val = 2 * val[0].abs_diff(val[val.len() - 1]) as i32;
                let mut minVal = i32::MAX;
                for i in 0..(val.len() - 2) {
                    minVal = min(minVal, 2 * (std::cmp::max(val[i], std::cmp::max(val[i + 1], val[i + 2])) - std::cmp::min(val[i], std::cmp::min(val[i + 1], val[i + 2]))) as i32);
                } 
                
                if res == -1 {
                    res = minVal;
                } else {
                    res = std::cmp::min(res, minVal);
                }
            }
        }

        // println!("{:?}", map);

        return res;
    }
}
