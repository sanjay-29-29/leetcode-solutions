use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn largest_integer(nums: Vec<i32>, k: i32) -> i32 {
        let mut map: HashMap<i32, i32> = HashMap::new();

        for i in 0..nums.len() - k as usize + 1 {
            let mut set: HashSet<i32> = HashSet::new();

            for j in 0..k as usize {
                set.insert(nums[i + j]);
            }

            for val in set.iter() {
                map.entry(*val).and_modify(|val| *val += 1).or_insert(1);
            }

            println!("{:?}", set);
        }

        let mut res = -1;

        for (k, v) in map.iter() {
            if *v == 1 {
                res = std::cmp::max(*k, res);
            }
        }

        return res;
    }
}
