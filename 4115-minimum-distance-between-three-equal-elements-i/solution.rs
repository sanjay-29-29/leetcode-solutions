impl Solution {
    pub fn minimum_distance(nums: Vec<i32>) -> i32 {
        let mut res = -1;

        for i in 0..nums.len() {
            for j in i + 1..nums.len() {

                if nums[i] != nums[j] {
                    continue;
                }

               for k in j + 1..nums.len() {
                    if nums[i] == nums[j] && nums[j] == nums[k] {
                        let val = ((i - j) as i32).abs() + ((j - k) as i32).abs() + ((k - i) as i32).abs();
                        if res == -1 {
                            res = val;
                        } else {
                            res = std::cmp::min(res, val);              
                        }
                    }
               }
            }
        }

        res
    }
}
